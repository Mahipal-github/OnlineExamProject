package com.cg.onlinetest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.User;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;
import com.cg.onlinetest.util.OnlineConstants;

/**
 *     @author       : K Mahipal Reddy
 *     @Description  : It is a service class that provides the services for adding a new User, 
                       new exam, viewing UserById viewing all users and all exams 
  *    @version      : 1.0
  *    @Created Date : 02-APR-2020
*/

@Transactional
@Service
public class IExamServiceImpl implements IExamService {

	@Autowired
	private IExamDao dao;

	/**
	 * @Method      : addUser()
	 * @Description : This method adds the user into the database by using dao method addUser 
	 * @param       : user is a parameter of type User entity that has all the user details
	 * @return      : It returns the boolean type true  if the user gets added 
	 * @throws      : If the userId entered while adding the user is not satisfied then it throws UserIdException
	 */
	
	@Override
	public boolean addUser(User user) throws UserIdException {

		dao.addUser(user);
		return true;

	}
	
	/**
	 * @Method      : addExam()
	 * @Descripiton : This method adds the exam information into the database by using dao method addExam 
	 * @param       : exam is an argument of type Exam entity that contains all the exam details
	 * @return      : It returns the boolean type true if the exam gets added 
	 * @throws      : If the examId entered while adding the exam is not satisfied then it throws ExamException
	 */

	@Override
	public boolean addExam(Exam exam) throws ExamException {

		dao.addExam(exam);
		return true;

	}
	
	/**
	 * @Method      : viewUserByID()
	 * @Description : This method shows us the user details from the database when we request using userId  
	 * @param       : userId is a parameter of type int with which we get user information
	 * @return      : It returns the user details if the given userId exists 
	 * @throws      : If the userId does not exists then it will show NotAvailableException
	 */

	@Override
	public User viewUserByID(int userId) throws NotAvailableException {
		User user = dao.viewUserByID(userId);
		if (user == null)
			throw new NotAvailableException(OnlineConstants.USER_NOT_FOUND);
		return user;
	}
	
	/**
	 * @Method      : viewExams()
	 * @Description : This method gives all the exams from the database in sorted  manner using viewExams 
	 *                method from dao implementation   
	 * @return      : It returns the examList which has all the details of exam i.e.,examId,examName,minutes
	 */

	@Override
	public List<Exam> viewExams() {
		List<Exam> examList = dao.viewExams();
		examList.sort((e1, e2)->e1.getExamName().compareTo(e2.getExamName()));
		return examList;
	}
	
	/**
	 * @Method      : viewUsers()
	 * @Description : This method gives all the users from the database in sorted manner using viewUsers 
	 *                method from dao implementation   
	 * @return      : It returns the userList which has all the details of user i.e.,userId,userName,role
	 */

	@Override
	public List<User> viewUsers() {
		List<User> userList = dao.viewUsers();
		userList.sort((e1, e2)->e1.getUserName().compareTo(e2.getUserName()));
		return userList;
	}
}
