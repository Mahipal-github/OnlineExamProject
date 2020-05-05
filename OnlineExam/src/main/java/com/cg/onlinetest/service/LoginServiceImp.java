package com.cg.onlinetest.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.LoginException;
import com.cg.onlinetest.dao.IExamDao;

@Service
@Transactional
public class LoginServiceImp implements LoginService{

	@Autowired
	private IExamDao dao;
	
	
//	Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
	
	@Override
	public User doLogin(int userId, String password)throws LoginException {
		User user = dao.viewUserByID(userId);
//		logger.debug("doing login process");
		
		if (user != null && user.getPassword().contentEquals(password)){
//			logger.info("User Authenticated for " + userId);
			return user;
		}
		throw new LoginException("You are not authenticated and authorized, Please Login");
	}

	@Override
	public String encryptUser(User user) {
		return encryptString(user.getUserId()+"")+"-" +encryptString(user.getUserName())+"-"
		      +encryptString(user.getRole());
	}
	
	public String encryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

	public String decryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

}
