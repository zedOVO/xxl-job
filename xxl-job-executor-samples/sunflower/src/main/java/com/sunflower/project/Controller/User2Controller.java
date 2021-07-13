package com.sunflower.project.Controller;

import com.sunflower.project.model.User2;
import com.sunflower.project.service.impl.UserService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="/user")
public class User2Controller {
	private static final Logger logger = LoggerFactory.getLogger(User2Controller.class);
	@Autowired
	private UserService2 userService2;

	@GetMapping(value = "/createuser")
	public ModelAndView createUserView() {
		ModelAndView modelAndView = new ModelAndView("createuser");
		modelAndView.addObject("user", new User2());
		modelAndView.addObject("allProfiles", getProfiles());
		return modelAndView;
	}

	@PostMapping("/createuser")
	public ModelAndView createUser(@Valid User2 user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			//直接返回一个页面
			modelAndView.setViewName("createuser");
			modelAndView.addObject("user", user);
			modelAndView.addObject("allProfiles", getProfiles());
			return modelAndView;
		}
		userService2.addUser(user);
		modelAndView.addObject("allUsers", userService2.getAllUsers());
		modelAndView.setViewName("userinfo");
		logger.info("Form submitted successfully.");
		return modelAndView;
	}

	private List<String> getProfiles() {
		List<String> list = new ArrayList<>();
		list.add("Associate");
		list.add("AVP");
		list.add("VP");
		list.add("Director");
		return list;
	}

	public static void main(String[] args) {
		
	}

}
