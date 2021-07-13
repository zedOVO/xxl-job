package com.sunflower.project.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Component
public class EmailUtil {
    public Session session = null;

    @Value("${EmailUtil.sendMail}")
    public String sendMail;

    @Value("${EmailUtil.sendMailPass}")
    public String pass;

    @Value("${EmailUtil.sendName}")
    public String sendName;


    @Value("${EmailUtil.AuthCode}")
    public String authCode;

    public EmailUtil(){
        init();
    }

    public void init() {
        if(session == null){
            session = Session.getInstance(initSetting(), new Authenticator() {
                //一般SMTP都需要授权码
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sendMail,authCode);
                }
            });
        }
    }

    /**
     *
     * @param recAddress 收件人邮箱 可以是多个 使用,分割
     * @param content 邮件正文
     * @param mailTile 邮件主题
     */
    public void send(String recAddress,String content,String mailTile) {
        MimeMessage message = createMimeMessage(sendMail,recAddress,session,content,mailTile);
        Transport transport = null;
        try {
            //根据session获取邮件传输对象
            transport = session.getTransport();
            //使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            //连接失败的原因通常为以下几点, 仔细检查代码:
            //           (1) 邮箱没有开启 SMTP 服务;
            //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
            //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
            //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
            //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
            transport.connect(sendMail,pass);
            //发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message,message.getAllRecipients());
            //关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱 可以是多个用,分割
     * @param session 和服务器交互的会话
     * @return 初始化完成的邮件对象
     */
    public MimeMessage createMimeMessage(String sendMail, String receiveMail, Session session,String content,String mailTile) {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        try {
            message.setFrom(new InternetAddress(sendMail, sendName, "UTF-8"));
            // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "", "UTF-8"));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(receiveMail));

            //4.Subject: 邮件主题
            message.setSubject(mailTile,"UTF-8");

            //5.content: 邮件正文（可以使用html标签）
            message.setContent(content,"text/html;charset=UTF-8");

            //6.设置发件时间
            message.setSentDate(new Date());

            //保存设置
            message.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return message;

    }

    /**
     * 初始化email配置
     *
     * @return
     */
    public Properties initSetting() {
        Properties pro = new Properties();
        pro.put("mail.transport.protocol", "SMTP");
        //设置使用验证
        pro.put("mail.smtp.auth", "true");
        //使用 STARTTLS安全连接
        pro.put("mail.smtp.starttls.enable","true");
        return pro;
    }
}
