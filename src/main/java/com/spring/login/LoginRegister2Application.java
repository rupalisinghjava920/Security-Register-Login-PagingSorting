package com.spring.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginRegister2Application {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegister2Application.class, args);
	}

}
