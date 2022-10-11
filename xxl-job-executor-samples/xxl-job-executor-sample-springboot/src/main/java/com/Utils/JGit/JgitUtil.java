package com.Utils.JGit;


import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import groovyjarjarantlr.collections.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.*;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class JgitUtil {


    public static void main(String[] args) {
//        UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider("zedOVO","Sishuizz7");
//        Git.lsRemoteRepository().setRemote("git@github.com:zedOVO/weixinApp.g
//        it").setCredentialsProvider(provider).getRepository();
        try {
            Git git = Git.open(new File("/Users/zed/Java/Project/IdeaWorkSpace/weixinApp"));
            git.checkout().setCreateBranch(false).setName("dev").setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK).call();
                git.pull().setTransportConfigCallback(new TransportConfigCallback() {
                @Override
                public void configure(Transport transport) {
                    SshTransport sshTransport = (SshTransport) transport;
                    sshTransport.setSshSessionFactory(new JschConfigSessionFactory() {
                        @Override
                        protected void configure(OpenSshConfig.Host host, Session session) {
                            CredentialsProvider provider = new CredentialsProvider() {
                                @Override
                                public boolean isInteractive() {
                                    return false;
                                }

                                @Override
                                public boolean supports(CredentialItem... credentialItems) {
                                    return false;
                                }

                                @Override
                                public boolean get(URIish urIish, CredentialItem... credentialItems) throws UnsupportedCredentialItem {
                                    for (CredentialItem item:credentialItems){
                                        ((CredentialItem.StringType) item).setValue("");
                                    }
                                    return true;
                                }
                            };
                            UserInfo userInfo = new CredentialsProviderUserInfo(session,provider);
                            session.setUserInfo(userInfo);
                            //解除HostKey检查，也就意味着可以接受未知的远程主机的文件，这是不安全的，这种模式只是用于测试为目的的。
                            //利用ssh-keyscan -t rsa hostname，收集主机数据。
                            session.setConfig("StrictHostKeyChecking", "no");
                        }
                    });

                }
            }).call();
//            Repository repository = git.getRepository();
//            git = new Git(repository);
//            Iterable<RevCommit> revCommits = git.log().call();
            Iterable<RevCommit> revCommits = git.log().addPath("src/main/java/com/app/weixinApp/Queue/MQueue.java").call();
            revCommits.forEach(r -> {
                //筛选提交人
                if("zeddd".equals(r.getAuthorIdent().getName())){

                }
                System.out.println(r.getName());
//                System.out.println(r.getFullMessage());
//                System.out.println(r.getCommitTime());
//                System.out.println(System.currentTimeMillis());
            });

//            System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(1659637858000L)));

        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Git git;

    public JgitUtil(String workSpace) {
        try {
            Repository repository = Git.open(new File(workSpace)).getRepository();
            this.git = new Git(repository);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map getGitInfo(String fileName) {
        Map retMap = new HashMap();
        Iterable<RevCommit> revCommits = null;
        try {
            revCommits = git.log().addPath("src/main/java/com/app/weixinApp/Queue/MQueue.java").call();
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
//        revCommits.forEach(r -> {
        for (RevCommit r : revCommits){
            //筛选提交人commit
            if ("zeddd".equals(r.getAuthorIdent().getName()))
            retMap.put("commitUser", r.getAuthorIdent().getName());
            retMap.put("hashCode", r.getName());
            retMap.put("commitDate", new SimpleDateFormat("yyyyMMdd").format((new Date((long) r.getCommitTime() * 1000))));
            return retMap;
        };
        return retMap;
    }

    public void getRemoteBranch(String url, String username, String password) {
        UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(username, password);
        Git.lsRemoteRepository().setRemote(url).setCredentialsProvider(provider);
        try {
            Git git = Git.open(new File("/Users/zed/Java/Project/IdeaWorkSpace/weixinApp/src/main/java/com/app/weixinApp/Controller/RequestController.java"));
            Iterable<RevCommit> revCommits = git.log().call();
            revCommits.forEach(r -> {
                r.getName();
            });

        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  查询单个文件的全部commitId
     * */
    public List searchAllCommitId() {
        return null;
    }

    /**
     * 传入文件路径解析文件git信息
     *
     * @param filePath 输出execl文件路径
     * @param sheet    输出sbeet
     * @param files    文件清单
     * @return
     * @throws IOException
     */
    public void resolveFile(String filePath, int sheet, Set<String> files, String outPath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet1 = workbook.getSheetAt(sheet);
        int i = 1;
        for (String file : files) {
            i++;
            Map info = getGitInfo(file);
            XSSFRow row = sheet1.createRow(i);
            //提交时间
            row.createCell(0).setCellValue(info.get("commitDate") + "");
            //文件路径
            row.createCell(1).setCellValue(file);
            //提交人
            row.createCell(2).setCellValue(info.get("commitUser") + "");
            //最新版本哈希值
            row.createCell(3).setCellValue(info.get("hashCode") + "");
        }
        FileOutputStream fos = new FileOutputStream(outPath);
        workbook.write(fos);
        workbook.close();
    }


    /**
     * 通过文件获取全部文件目录
     *
     * @param filePath 解析文件目录
     * @return 文件清单
     * @throws IOException
     */
    public Set getAllFiles(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Set<String> files = new HashSet<>();
        int i = 0;
        while (reader.ready()) {
            files.add(reader.readLine());
        }
        return files;
    }

}
