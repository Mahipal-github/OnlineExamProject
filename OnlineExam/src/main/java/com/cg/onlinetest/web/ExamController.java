package com.cg.onlinetest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.dto.ExamMessage;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;
import com.cg.onlinetest.service.IExamService;
import com.cg.onlinetest.util.OnlineConstants;

@RestController
public class ExamController {

	@Autowired
	private IExamService service;
    @CrossOrigin
	@PostMapping("/addUser")
	public ExamMessage addUser(@RequestBody User user) throws UserIdException, ExamException {
		try {
			service.addUser(user);
			ExamMessage msg = new ExamMessage();
			msg.setMessage(OnlineConstants.USER_ADDED);
			return msg;
		} catch (DataIntegrityViolationException ex) {
			throw new ExamException(OnlineConstants.ID_EXISTS);
		}
	}
    @CrossOrigin
	@PostMapping("/addExam")
	public ExamMessage addExam(@RequestBody Exam exam) throws ExamException {
		try {
			service.addExam(exam);
			ExamMessage msg = new ExamMessage();
			msg.setMessage(OnlineConstants.EXAM_ADDED);
			return msg;
		} catch (DataIntegrityViolationException ex) {
			throw new ExamException(OnlineConstants.ID_EXISTS);
		}
	}
    @CrossOrigin
	@GetMapping("/viewuserbyid/{userid}")
	public User viewUserByID(@PathVariable("userid") int userId) throws NotAvailableException {
	try {
		ExamMessage msg = new ExamMessage();

	service.viewUserByID(userId);	
		return service.viewUserByID(userId);
	}
	catch(DataIntegrityViolationException ex) {
		throw new NotAvailableException(OnlineConstants.USER_NOT_FOUND);
	}
	}
    @CrossOrigin
	@GetMapping("/viewexams")
	public List<Exam> viewExams() throws NotAvailableException {
		return service.viewExams();
	}
	@CrossOrigin
	@GetMapping("/viewusers")
	public List<User> viewUsers() throws NotAvailableException {
		return service.viewUsers();
		
		
	}
}
