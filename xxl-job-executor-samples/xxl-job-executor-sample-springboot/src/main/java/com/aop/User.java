package com.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class User implements BaseDomain {

    public String createDate;



    public String createUser;


    @Override
    public void setCreateDate() {
        this.createDate = DateUtil.getNowDate("yyyyMMddHHmmss");
    }

    @Override
    public void setCreateUser(String user) {
        this.createUser = user;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "createDate='" + createDate + '\'' +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
