package com.cg.onlinetest.service;
//
import java.util.List;
import java.util.Map;
//
import com.cg.onlinetest.dto.Answer;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.exceptions.ExamException;
//
public interface IExamUserService {
//
	public List<Questions> viewQuestionsForExamId(int examId) throws ExamException;

public int generateScore(List<Answer> answers, int examId, int userId);
//	
//
}