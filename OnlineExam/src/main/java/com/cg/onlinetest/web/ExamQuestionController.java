package com.cg.onlinetest.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.dto.Answer;
import com.cg.onlinetest.dto.ExamMessage;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.LoginException;
import com.cg.onlinetest.service.IExamUserService;
import com.cg.onlinetest.util.OnlineConstants;
//
//
@RestController
public class ExamQuestionController {
//	
@Autowired
private IExamUserService service;

	@CrossOrigin
	@GetMapping("/viewQuestionsForExamId/{examid}")
	public List<Questions> viewQuestionsForExamId(@PathVariable("examid") int examid, HttpServletRequest req) throws ExamException, LoginException {
	return service.viewQuestionsForExamId(examid);
}
//	
	@CrossOrigin
	@PostMapping("/submitanswers/{examid}/{userid}")
	public ExamMessage submitAnswersForExamId(@PathVariable("examid") int examId,@PathVariable("userid") int userId, @RequestBody List<Answer> answers) throws ExamException {
		int score = service.generateScore(answers, examId, userId);
		ExamMessage msg = new ExamMessage();
		msg.setMessage(OnlineConstants.SCORE + score);
		return msg;
	}

}