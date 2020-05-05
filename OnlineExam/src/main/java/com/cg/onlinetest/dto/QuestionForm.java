package com.cg.onlinetest.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuestionForm {

	
	private String questionTitle;
	
	private String OptA;
	private String OptB;
	private String OptC;
	private String OptD;	
	private String answer;
	private int examId;
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOptA() {
		return OptA;
	}
	public void setOptA(String optA) {
		OptA = optA;
	}
	public String getOptB() {
		return OptB;
	}
	public void setOptB(String optB) {
		OptB = optB;
	}
	public String getOptC() {
		return OptC;
	}
	public void setOptC(String optC) {
		OptC = optC;
	}
	public String getOptD() {
		return OptD;
	}
	public void setOptD(String optD) {
		OptD = optD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	
	
}
