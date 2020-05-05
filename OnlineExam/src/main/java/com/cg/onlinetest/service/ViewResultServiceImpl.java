package com.cg.onlinetest.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.util.OnlineConstants;

@Service
public class ViewResultServiceImpl implements ViewResultService {
	
	@Autowired
	IExamDao dao;

	public List<ExamUserAssign> viewExamHistoryForUserAttended(int userId) throws NotAvailableException {
		List<ExamUserAssign> lst = dao.getExamUserAssign(userId);
		System.out.println("service:" + lst);
		List<ExamUserAssign> assignList = lst.stream().filter(examassign-> !examassign.isStatus()).collect(Collectors.toList());
		if(assignList.isEmpty())
			throw new NotAvailableException(OnlineConstants.EXAM_HISTORY);
		assignList.sort((e1,e2)->e2.getDateOfExam().compareTo(e1.getDateOfExam()));
		return assignList;
	}

	@Override
	public List<ExamUserAssign> viewExamForUserToTake(int userId) throws NotAvailableException {
		List<ExamUserAssign> lst = dao.getExamUserAssign(userId);
		
		List<ExamUserAssign> assignList = lst.stream().filter(examassign-> examassign.isStatus()).collect(Collectors.toList());
		if(assignList.isEmpty())
			throw new NotAvailableException(OnlineConstants.EXAM_NOT_AVAILABLE);
		assignList.sort((e1,e2)->e2.getDateOfExam().compareTo(e1.getDateOfExam()));
		
		return assignList;
	}

//	@Override
//	@Transactional
//	public boolean addUser(User user) {
//		return dao.addUser(user);
//	}

	
}
