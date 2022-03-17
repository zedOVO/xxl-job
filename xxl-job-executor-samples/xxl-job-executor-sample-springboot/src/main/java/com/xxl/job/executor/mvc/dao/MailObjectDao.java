package com.xxl.job.executor.mvc.dao;

import com.xxl.job.executor.mvc.pojo.MailObject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailObjectDao {

    public MailObject query();

    public void addPreMail(MailObject mailInfo);
}
