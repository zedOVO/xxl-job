package com.sunflower.project.Controller;

import com.sunflower.project.xxlJob.AutoTaskSendEmail;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestTaskJobController {

    @Autowired
    private AutoTaskSendEmail sendEmail;

    @XxlJob("SendMailJob")
    @RequestMapping(value = "/task/testTask")
    public String executeTask(){
//        ModelAndView modelAndView = new ModelAndView("success");
        sendEmail.excute();
        return "success";
    }

}
