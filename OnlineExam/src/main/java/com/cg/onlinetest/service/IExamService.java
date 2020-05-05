package com.cg.onlinetest.service;

import java.util.List;

import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;

public interface IExamService {

	boolean addUser(User user) throws UserIdException;
	boolean addExam(Exam exam) throws ExamException;
	public User viewUserByID(int userId) throws NotAvailableException;
	public List<Exam> viewExams();
	public List<User> viewUsers();
	}
