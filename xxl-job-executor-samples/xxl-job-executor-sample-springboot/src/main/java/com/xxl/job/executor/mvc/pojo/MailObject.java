package com.xxl.job.executor.mvc.pojo;

import java.util.Date;

/**
 * 待发送邮件对象
 */
public class MailObject {
    //发送邮箱标题
    private String title;
    //发送邮箱正文
    private String body;
    //收件人邮箱地址
    private String rcvAddress;
    //实际发送邮件时间
    private Date sendTime;
    //发送短信标识
    private String sendFlag;
    //异常信息
    private String exceptionInfo;
    //预约发送时间
    private String preSendDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRcvAddress() {
        return rcvAddress;
    }

    public void setRcvAddress(String rcvAddress) {
        this.rcvAddress = rcvAddress;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String isSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getPreSendDate() {
        return preSendDate;
    }

    public void setPreSendDate(String preSendDate) {
        this.preSendDate = preSendDate;
    }

    @Override
    public String toString() {
        return "MailObject{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", rcvAddress='" + rcvAddress + '\'' +
                ", sendTime=" + sendTime +
                ", sendFlag='" + sendFlag + '\'' +
                ", exceptionInfo='" + exceptionInfo + '\'' +
                ", preSendDate='" + preSendDate + '\'' +
                '}';
    }

    public MailObject(String title,String body,String preSendDate,String rcvAddress){
        this.title = title;
        this.body = body;
        this.preSendDate = preSendDate;
        this.rcvAddress = rcvAddress;
    }

    public MailObject(){};
}
