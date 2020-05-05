package com.cg.onlinetest.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.dto.QuestionForm;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.util.OnlineConstants;

@Service
@Transactional
public class ExamAdminServiceImpl implements IExamAdminService {
	
	@Autowired
	IExamDao dao;

	public boolean addQuestion(QuestionForm qForm)
	{
		Questions ques =new Questions();
		ques.setQuestionTitle(qForm.getQuestionTitle());
		ques.setOptA(qForm.getOptA());
		ques.setOptB(qForm.getOptB());
		ques.setOptC(qForm.getOptC());
		ques.setOptD(qForm.getOptD());
		ques.setAnswer(qForm.getAnswer());
		
		ques.getExam().setExamId(qForm.getExamId());
		addQuestion(ques);
		return true;
	}
	public boolean addQuestion(Questions question) {
		int qid = dao.getMaxQuestionId() + 1;
		question.setQuestionId(qid);
		return dao.addQuestion(question);
	}

	public boolean assignExamToUser(int examId, int userId) {
	   int id = dao.getMaxExamUserAssignId()+1;
	   ExamUserAssign assign = new ExamUserAssign();
	   assign.setExamUserAssignId(id);
	   assign.setDateOfExam(LocalDate.now());
	   assign.setStatus(OnlineConstants.READY_TO_START);
	   Exam exam = new Exam();
	   exam.setExamId(examId);
	   assign.setExam(exam);
	   User user=new User();
	   user.setUserId(userId);
	   assign.setUser(user);
		return dao.assignExamToUser(assign);
		
	}
	
	@Override
	public boolean addQuestions(List<Questions> questions) {
		questions.stream().forEach(q->addQuestion(q));
		return true;
	}

	
}
