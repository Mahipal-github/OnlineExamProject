package com.cg;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.web.LoginInterceptor;


@SpringBootApplication
public class OnlineExamApplication implements WebMvcConfigurer {

	static Logger logger =LoggerFactory.getLogger(OnlineExamApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
	}
	
	@Autowired
	public LoginInterceptor loginInterceptor;
	
//	@Autowired
//	public AdminInterceptor adminInterceptor;

	

	@Bean(name="authenticatemap")
	public Map<String, User> getAuthenticateMap() {
		return new HashMap<>();
	}

	
	public void addInterceptors(InterceptorRegistry registry) {
	//	registry.addInterceptor(loginInterceptor).addPathPatterns(new String[] {"/viewexamhistory","/viewpdf","/viewexamtotake/*"});
		//registry.addInterceptor(adminInterceptor).addPathPatterns(new String[] {"/viewexamhistory","/viewexamtotake/*"});
	}
}
