package com.xxl.job.executor.mvc.controller;

import com.xxl.job.executor.mvc.dao.MailObjectDao;
import com.xxl.job.executor.mvc.pojo.MailObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Controller
@ResponseBody
@RequestMapping(value = "/mail")
public class MailObjectController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MailObjectDao mailObjectDao;

    @GetMapping("/query.do")
    public MailObject query(HttpServletResponse response,ModelAndView modelAndView){
        logger.info("查询待发送邮件");
        response.setStatus(200);
        MailObject mail = mailObjectDao.query();
        logger.info(mail.toString());
        return mail;
    }

    @PostMapping("/addPreMail.do")
    public String addPreMail(HttpServletRequest request,
                             @RequestParam String title,
                             @RequestParam String body,
                             @RequestParam String preSendDate,
                             @RequestParam String rcvAddress) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MailObject mailInfo = new MailObject(title,body,preSendDate,rcvAddress);
        Method method = MailObjectController.class.getMethod("testInvokeMethod",String.class);
        method.invoke("测试反射调用方法");
        mailObjectDao.addPreMail(mailInfo);
        return "SUCCESS";
    }


    public void testInvokeMethod(String s){
        System.out.println(s);
    }
}
