package com.cg.onlinetest.service;
//
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//
import com.cg.onlinetest.dao.ExamDaoImpl;
import com.cg.onlinetest.dao.IExamDao;
import com.cg.onlinetest.dto.Answer;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.util.OnlineConstants;
//
//
@Service
@Transactional
public class IExamUserServiceImpl implements IExamUserService {
	@Autowired
	private IExamDao dao;
//	
	@Value("${maxQues}")
	private int maxQues;
//
//	/**
//	 * @author : Ambala Sai Prudhvi
//	 * @Method : This method generates the questions from the getQuestions method in
//	 *           dao layer
//	 * @param  : testId parameter is passed as an argument so that the questions can
//	 *           be generated for the assigned testId
//	 * @return : It returns the list of Questions
//	 * @throws : If testId is not valid it throws ExamException
//	 */
//
	@Override
	public List<Questions> viewQuestionsForExamId(int examId) throws ExamException {
	List<Questions> lst = new ArrayList<>();
		Set<Integer> qnos = generateQnos();
		Map<Integer, Questions> qmap =getQuestionsAsMap(examId);
		for (int qno : qnos) {
			lst.add(qmap.get(qno));
		}
		return lst;
	}
//
	public Map<Integer, Questions> getQuestionsAsMap(int examId){
		List<Questions> quesLst = dao.viewQuestionsForExamId(examId);
		System.out.println("adfs");
		Map<Integer, Questions> qmap = quesLst.stream().collect(Collectors.toMap(Questions::getQuestionId,q->q));
		return qmap;
	}
//	/**
//	 * @author : Ambala Sai Prudhvi
//	 * @Method : This method checks the user answer against the actual answer and
//	 *           evaluates the score
//	 * @param  : umap pass the map having qid and answers which answered by the
//	 *           user, qlist has the list of Questions
//	 * @return : It returns the score for correct user answers
//	 */
//	
@Override
	public int generateScore(List<Answer> answers, int examId, int userId) {
//		
	int score = OnlineConstants.ZERO;
		String actualAns =OnlineConstants.EMPTY;
		Questions ques = null;
		Map<Integer, Questions> qmap =getQuestionsAsMap(examId);
		for (Answer answer : answers) {

			ques = qmap.get(answer.getQuesId());
			actualAns = ques.getAnswer();
			if (answer.getAnswer() != null && answer.getAnswer().length() > OnlineConstants.ZERO && 
										answer.getAnswer().equalsIgnoreCase(actualAns))
				++score;
			
		}
		List<ExamUserAssign> elist = dao.getExamUserAssign(userId);
		System.out.println( "Exam User Assign "+elist.size());
		long c =elist.stream().filter(ea -> ea.getExam().getExamId() == examId).count();
		System.out.println("Count " + c);
		ExamUserAssign examUser=elist.stream().filter(ea -> ea.getExam().getExamId() == examId).findFirst().get();
		examUser.setStatus(false);
		examUser.setMarks(score);
		dao.editassignExamToUser(examUser);
		return score;
	}
//
//	/**
//	 * @author : Ambala Sai Prudhvi
//	 * @Method : This method generates unique random question numbers
//	 * @return : Set<Integer> having random unique Question no's
//	 */
//	
	public Set<Integer> generateQnos() {
		Set<Integer> set = new HashSet<>();
		Random rand = new Random();
		int num = OnlineConstants.ZERO;
		while (set.size() < maxQues) {
			num = rand.nextInt(OnlineConstants.END_QUES_BOUND) + OnlineConstants.START_QUES_BOUND;
			set.add(num);
		}
//
		return set;
	}
//
}