package com.smart.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.smart.dao.UserRepository;

@Controller
//@RequestMapping("/user")
public class UserController {

//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private UserRepository userRepository;
	
	@RequestMapping("/user/index")
	public String dashboard(Model model,Principal principal) {
		String email=principal.getName();
		System.out.println("EMAIL " + email);
		model.addAttribute("title","Login-Smart Contact Manager");
		return "normal/user_dashboard";
	}
}
