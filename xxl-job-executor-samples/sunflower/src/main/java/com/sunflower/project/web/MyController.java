package com.sunflower.project.web;

import com.sunflower.project.core.Result;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.core.ServiceException;
import com.sunflower.project.model.News;
import com.sunflower.project.model.Picfile;
import com.sunflower.project.model.User;
import com.sunflower.project.model.UserAccount;
import com.sunflower.project.request.Request;
import com.sunflower.project.request.UpdatePasswordRequest;
import com.sunflower.project.service.NewsService;
import com.sunflower.project.service.PicfileService;
import com.sunflower.project.service.UserAccountService;
import com.sunflower.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyController {
    @Resource
    private UserService userService;
    @Resource
    private UserAccountService userAccountService;
    @Resource
    private NewsService newsService;

    private Logger logger=LoggerFactory.getLogger(getClass());

    @Resource
    private PicfileService picfileService;

    @Value("${upload-path}")
    private String uploadpath ;

    @PostMapping("/picfile/upload")
    public Result upload(@RequestParam MultipartFile file) {
        String filename = file.getOriginalFilename();
        File f =  new File(uploadpath,filename);
        if (!f .getParentFile().exists()) {
            f .getParentFile().mkdirs();
        }

        try {
            FileCopyUtils.copy(file.getBytes(),f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //存数据
        Picfile picfile = new Picfile();
        picfile.setName(filename);
        picfile.setPath(uploadpath);
        picfile.setUrl("/picfile/"+filename);
        picfile.setBytes( (int)file.getSize());
        picfileService.save(picfile);
        picfile = picfileService.findById(picfile.getId());
        return ResultGenerator.genSuccessResult(picfile);
    }
    @PostMapping("/user/login")
    public Result login2(@RequestBody UserAccount userAccount) {
        System.out.println(userAccount);
        String username  = userAccount.getUsername();
        String password  = userAccount.getPassword();
        UserAccount userAccountDb = checkPassword(username,password);
        User user = userService.findById(userAccountDb.getUserId());
        return ResultGenerator.genSuccessResult(user);
    }
    @PostMapping("/user/account/update")
    public Result update(@RequestBody UpdatePasswordRequest request) {
        UserAccount userAccount = checkPassword(request.getUsername(),request.getPassword());
        String md5Password=getMD5(request.getNewPassword());
        userAccount.setPassword(md5Password);
        userAccountService.update(userAccount);
        User user = userService.findById(userAccount.getUserId());
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/user/update")
    public Result updateuser(@RequestBody User user){
        logger.info(user.getNickName());
        String nickName= user.getNickName();
        if(user==null||user.getId()==null)throw new ServiceException("上送参数有误");
        User dbuser = userService.findById(user.getId());
        if(dbuser==null) throw  new ServiceException("用户不存在");
        if(!StringUtils.isEmpty(user.getCreateTime()))dbuser.setCreateTime(user.getCreateTime());
        if(!StringUtils.isEmpty(user.getEmail()))dbuser.setEmail(user.getEmail());
        if(!StringUtils.isEmpty(user.getNickName()))dbuser.setNickName(user.getNickName());
        if(!StringUtils.isEmpty(user.getMobile()))dbuser.setMobile(user.getMobile());
        userService.update(dbuser);
        dbuser=userService.findById(dbuser.getId());
        return ResultGenerator.genSuccessResult(dbuser);
    }

    @PostMapping("/news/next")
    public Result next(@RequestBody Request request){
        News news = newsService.findNextById(request.getId());
        return ResultGenerator.genSuccessResult(news);
    }
    @PostMapping("/news/before")
    public Result before(@RequestBody Request request){
        News news = newsService.findBeforeById(request.getId());
        return ResultGenerator.genSuccessResult(news);
    }
    private String getMD5(String str){
        String slat = "&%5123***&&%%$$#@";
        return DigestUtils.md5DigestAsHex((str +"/"+slat).getBytes());
    }

    private UserAccount checkPassword(String username,String password){
        if(StringUtils.isEmpty(username))throw new ServiceException("用户名不能为空");
        if(StringUtils.isEmpty(password))throw new ServiceException("密码不能为空");
        UserAccount userAccount = userAccountService.findBy("username",username);
        if(userAccount!=null && userAccount.getErrors()>=5)throw new ServiceException("登录错误次数过多");
        if(userAccount==null) throw new ServiceException("用户不存在");
        String md5=getMD5(password);
        if(!userAccount.getPassword().equals(md5)){
            userAccount.setErrors(userAccount.getErrors()+1);
            userAccountService.update(userAccount);
            throw new ServiceException("密码不正确");
        }
        userAccount.setErrors(0);
        userAccountService.update(userAccount);
        logger.info("账户{}权限验证成功",userAccount.getUsername());
        return userAccount;
    }
}
