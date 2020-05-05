package com.cg.onlinetest.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="lpu_exam_assign")
@DynamicUpdate
@DynamicInsert
public class ExamUserAssign {
	@Id
	@Column(name="exam_user_id")
	private int examUserAssignId;
	
	@Column(name="exam_marks")
	private int marks;
	
	@Column(name="user_status")
	private boolean status;
	
	@Column(name="date_of_exam")
	private LocalDate dateOfExam;
	
	@ManyToOne
	@JoinColumn(name="user_id" , referencedColumnName = "user_id")
	private User user ;
	
	@ManyToOne
	@JoinColumn(name="exam_id" , referencedColumnName = "exam_id")
	private Exam exam ;
	
	
	public int getExamUserAssignId() {
		return examUserAssignId;
	}
	public void setExamUserAssignId(int examUserAssignId) {
		this.examUserAssignId = examUserAssignId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDate getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	
	
	
	
}
