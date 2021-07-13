package com.sunflower.project.util;

import com.google.common.base.Charsets;
import com.jcraft.jsch.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;


public class SftpUtil {
    public String HOST;
    public int PORT;
    public String USER;
    public String PASS;

    public Session session;
    public ChannelSftp channel;

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public SftpUtil(String host, int port, String user, String pass) {
        this.HOST = host;
        this.PORT = port;
        this.USER = user;
        this.PASS = pass;
    }

    public void init() {
        JSch jSch = new JSch();
        Session session = null;
        try {
            session = jSch.getSession(USER, HOST, PORT);
            session.setTimeout(60 * 1000);
            session.setPassword(PASS);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            this.session = session;
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public ChannelSftp getChannel(){
        if (channel == null){
            try {
                channel = (ChannelSftp) session.openChannel("sftp");
            } catch (JSchException e) {
                e.printStackTrace();
            }
        }
        return channel;
    }

    public void closeConnect(){
        this.channel.disconnect();
        this.session.disconnect();
    }

    public void get(String filePath,String targetPath){
        if (StringUtils.isBlank(filePath) || StringUtils.isBlank(targetPath)){
            return;
        }
        File file = new File(targetPath);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(InputStream in = channel.get(filePath);
            FileOutputStream fout = new FileOutputStream(new File(targetPath));
        ){
            byte[] b = new byte[10*1024];
            int i = 0;
            while ((i = in.read(b))!= -1){
                fout.write(b);
                fout.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] get(String filePath){
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        try(InputStream in = channel.get(filePath)){
            byte[] b = new byte[10*1024];
            int i = 0;
            while ((i = in.read(b))!= -1){
                sb.append(new String(b,Charsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().getBytes();
    }


    public void remove(String targetFile){
        try {
            channel.rm(targetFile);
        } catch (SftpException e) {
//            Trace.print("删除文件失败"+e.getMessage(), TraceLevel.DEFAULT);
            e.printStackTrace();
        }
    }



}
