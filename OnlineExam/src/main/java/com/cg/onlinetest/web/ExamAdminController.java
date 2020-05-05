package com.cg.onlinetest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.dto.ExamMessage;
import com.cg.onlinetest.dto.QuestionForm;
import com.cg.onlinetest.entity.ExamUserAssign;
import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.service.IExamAdminService;
import com.cg.onlinetest.service.IExamService;
import com.cg.onlinetest.util.OnlineConstants;

@RestController
public class ExamAdminController {
	
	@Autowired
	private IExamAdminService service;
	
	@CrossOrigin
	@PostMapping("/addQuestion")
	public ExamMessage addQuestion(@RequestBody QuestionForm questionForm) {
		service.addQuestion(questionForm);
		 ExamMessage msg = new ExamMessage();
		 msg.setMessage(OnlineConstants.QUES_ADDED);
		 return msg;
	}
	
	@CrossOrigin
	@GetMapping("/assignExam/{examid}/{userid}")
	public ExamMessage assignExamToUser( @PathVariable("examid") int examId, @PathVariable("userid") int userId) {
		
		service.assignExamToUser(examId, userId);
		ExamMessage msg = new ExamMessage();
		 msg.setMessage(OnlineConstants.EXAM_ASSIGNED);
		 return msg;
	}

}
