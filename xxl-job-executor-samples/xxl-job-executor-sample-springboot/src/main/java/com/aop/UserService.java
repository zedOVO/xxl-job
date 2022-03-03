package com.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public BaseDomain addUser(BaseDomain baseDomain){
        return baseDomain;
    }
}
