package com.xxl.job.admin.test;

import org.springframework.util.DigestUtils;

public class Digest {

    public static void main(String[] args) {
        //加密明文获得密文串与库中字符串对比
        String md5Str = DigestUtils.md5DigestAsHex("admin".getBytes());
    }
}
