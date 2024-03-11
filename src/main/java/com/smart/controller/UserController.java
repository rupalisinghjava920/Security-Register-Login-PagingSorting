package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entity.User;

@Configuration
@RequestMapping("/user")
public class UserController {

//	@Autowired
//	private UserDetailsService userDetailsService;
//	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/index")
	public String dashboard(Model model) {
		model.addAttribute("title","Login-Smart Contact Manager");
		return "normal/user_dashboard";
	}
}
