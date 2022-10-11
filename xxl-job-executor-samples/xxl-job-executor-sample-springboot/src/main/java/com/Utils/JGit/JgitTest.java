package com.Utils.JGit;

import java.io.IOException;

public class JgitTest {
    public static void main(String[] args) throws IOException {
        JgitUtil util = new JgitUtil("/Users/zed/Java/Project/IdeaWorkSpace/weixinApp");
        util.resolveFile("/Users/zed/Documents/test/GitInfo.xlsx",0,util.getAllFiles("/Users/zed/Documents/test/gitRead.txt"),"/Users/zed/Documents/test/outGitInfo.xlsx");

    }
}
