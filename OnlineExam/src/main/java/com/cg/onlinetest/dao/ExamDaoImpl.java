package com.cg.onlinetest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.entity.User;

@Repository
public class ExamDaoImpl implements IExamDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addUser(User user) {
		em.persist(user);
		return true;
	}
	@Override
	public User getUser(String userId){
		   return   em.find(User.class, userId);
		}

	@Override
	public boolean editUser(User user) {
		em.merge(user);
		return true;
	}

	@Override
	public List<User> viewUsers() {
		String jpql = "from User";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		
		return query.getResultList();
	}
	@Override
	public User viewUserByID(int userId) {
		return em.find(User.class, userId);
		
	}
	@Override
	public boolean addExam(Exam exam) {
		em.persist(exam);
		return true;
	}

	@Override
	public boolean editExam(Exam exam) {
		em.merge(exam);
		return true;
	}
	@Override
	public List<Exam> viewExams() {
		String jpql = "from Exam";
		TypedQuery<Exam> query = em.createQuery(jpql, Exam.class);
		
		return query.getResultList();
		
	}
	@Override
	public Exam getExam(int examId) {
		
		return em.find(Exam.class, examId);
	}

	@Override
	public boolean addQuestion(Questions question) {
		em.persist(question);
		return true;
	}

	@Override
	public boolean editQuestion(Questions question) {
		em.merge(question);
		return true;
	}

	@Override
	public boolean removeQuestion(Questions question) {
		em.remove(question);
		return true;
	}

	@Override
	public boolean assignExamToUser(ExamUserAssign assign) {
		em.persist(assign);
		return true;
	}

	
	@Override
	public boolean editassignExamToUser(ExamUserAssign assign) {
		em.persist(assign);
		return true;
	}

	@Override
	public List<Questions> viewQuestionsForExamId(int examId) {
		String jpql = "from Questions q inner join fetch q.exam e where e.examId=:eid";
		TypedQuery<Questions> query = em.createQuery(jpql, Questions.class);
		query.setParameter("eid", examId);
		return query.getResultList();
	}

	

	@Override
	public List<ExamUserAssign> getExamUserAssign(int userId) {
		String jpql = "from ExamUserAssign examuser inner join fetch examuser.exam e inner join fetch examuser.user u where u.userId=:userid";
		TypedQuery<ExamUserAssign> query = em.createQuery(jpql, ExamUserAssign.class);
		query.setParameter("userid", userId);
		return query.getResultList();
	}

	@Override
	public List<ExamUserAssign> getExamUserAssign() {
		String jpql = "from ExamUserAssign examuser inner join fetch examuser.user u inner join fetch examuser.exam e";
		TypedQuery<ExamUserAssign> query = em.createQuery(jpql, ExamUserAssign.class);
		
		return query.getResultList();
	}

	@Override
	public int getMaxQuestionId() {
		String jpql = "select max(questionId) from Questions";
		TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
		
		return query.getSingleResult();
	}

	@Override
	public int getMaxExamUserAssignId() {
		String jpql = "select max(examUserAssignId) from ExamUserAssign";
		TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
		
		return query.getSingleResult();
	}

	

	
	
	

}
