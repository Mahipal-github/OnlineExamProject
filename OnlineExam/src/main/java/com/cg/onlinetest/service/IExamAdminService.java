package com.cg.onlinetest.service;

import java.util.List;

import com.cg.onlinetest.dto.QuestionForm;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;

public interface IExamAdminService {
	
	public boolean addQuestion(Questions question);
	public boolean assignExamToUser(int examId, int userId);
	public boolean addQuestions(List<Questions> questions);
	public boolean addQuestion(QuestionForm qForm);
	
	

}
