package com.cg.onlinetest.service;

import java.util.List;

import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.NotAvailableException;

public interface ViewResultService {
	
	public List<ExamUserAssign> viewExamHistoryForUserAttended(int userId)throws NotAvailableException;
	public List<ExamUserAssign> viewExamForUserToTake(int userId)throws NotAvailableException;
//	public boolean addUser(User user);

}
