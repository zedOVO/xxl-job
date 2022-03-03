package com.aop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/addUser")
    @ResponseBody
    public BaseDomain addUser(@RequestParam(required = false) String username){
        BaseDomain user= new User();
        user.setCreateUser(username);
        return userService.addUser(user);
    }
}
