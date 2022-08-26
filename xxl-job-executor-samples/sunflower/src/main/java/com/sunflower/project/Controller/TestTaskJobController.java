package com.sunflower.project.Controller;

import com.sunflower.project.xxlJob.AutoTaskSendEmail;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@EnableScheduling
@Controller
public class TestTaskJobController {

    @Autowired
    private AutoTaskSendEmail sendEmail;

    @Scheduled(cron = "0 0/5 * * * ? ")
    @XxlJob("SendMailJob")
    @RequestMapping(value = "/task/testTask")
    public String executeTask(){
//        ModelAndView modelAndView = new ModelAndView("success");
        sendEmail.execute();
        return "SUCCESS";
    }

}
