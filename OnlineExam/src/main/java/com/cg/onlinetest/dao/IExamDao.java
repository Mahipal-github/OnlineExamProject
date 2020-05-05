package com.cg.onlinetest.dao;

import java.util.List;

import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.entity.User;

public interface IExamDao {

	public boolean addUser(User user);
	public boolean editUser(User user);
	public User getUser(String userId);
	public List<User> viewUsers();
	
	
	public User viewUserByID(int userId);
	public boolean addExam(Exam exam);
	public boolean editExam(Exam exam);
	public List<Exam> viewExams();
	public Exam getExam(int examId);
	
	public boolean addQuestion(Questions question);
	public boolean editQuestion(Questions question);
	public boolean removeQuestion(Questions question);
	public int getMaxQuestionId();
	
	public boolean assignExamToUser(ExamUserAssign assign);
	public boolean editassignExamToUser(ExamUserAssign assign);
	
	public List<Questions> viewQuestionsForExamId(int examId);
	public List<ExamUserAssign> getExamUserAssign(int userId);
	public List<ExamUserAssign> getExamUserAssign();
	public int getMaxExamUserAssignId();
	
}
