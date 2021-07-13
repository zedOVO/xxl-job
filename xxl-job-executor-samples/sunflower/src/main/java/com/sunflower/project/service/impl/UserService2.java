package com.sunflower.project.service.impl;

import com.sunflower.project.model.User2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService2 {
	private List<User2> userList = new ArrayList<>();
	public List<User2> getAllUsers(){
		return userList;
	}
	public void addUser(User2 user) {
		userList.add(user);
	}
} 