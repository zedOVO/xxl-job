package com.aop;


/**
 * 所有数据库插入更新等操作的时间戳更新
 * 通过spring AOP切面插入
 */
public  interface BaseDomain {

    public  void setCreateDate();
    public  void setCreateUser(String user);
    public  String toString();
}
