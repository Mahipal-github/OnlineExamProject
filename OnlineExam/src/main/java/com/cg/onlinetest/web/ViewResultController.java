package com.cg.onlinetest.web;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.LoginException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;
import com.cg.onlinetest.service.ViewResultService;

@RestController
public class ViewResultController {
	
	
	@Autowired
	private ViewResultService service;
	
	@CrossOrigin
	@GetMapping("/viewexamhistory/{userId}")
	public List<ExamUserAssign> getExamHistory(@PathVariable("userId") int userId) throws NotAvailableException {
		return service.viewExamHistoryForUserAttended(userId);
	}

	@CrossOrigin
	@GetMapping("/viewexamtotake/{userId}")
	public List<ExamUserAssign> getExamForUser(@PathVariable("userId") int userId) throws NotAvailableException {
		return service.viewExamForUserToTake(userId);
	}
	
//	@CrossOrigin
//	@PostMapping("/adduser")
//	public String addUser(@RequestBody User user, HttpServletRequest req ) throws UserIdException,LoginException{
//		try {
//			if((boolean)req.getAttribute("authFlag"))
//			service.addUser(user);
//			return "Successfully Added!"; 
//		
//		}catch(Exception ex) {
//			throw new UserIdException();
//		}
		
		
	
}
