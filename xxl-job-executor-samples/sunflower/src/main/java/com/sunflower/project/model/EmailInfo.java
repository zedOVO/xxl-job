package com.sunflower.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class EmailInfo implements Serializable {
    //收件人邮箱及抄送人邮箱
    private String recAddress;
    //执行日期
    private String executeDate;
    //执行状态  0：待执行 1：执行完成 9：执行失败
    private String stt;
    //邮件正文
    private String content;
    //邮件标题
    private String title;
    //异常信息
    private String exceptionInfo;
}
