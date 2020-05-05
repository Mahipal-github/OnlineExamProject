package com.cg.onlinetest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlinetest.dto.ExamMessage;
import com.cg.onlinetest.exceptions.ExamException;
import com.cg.onlinetest.exceptions.LoginException;
import com.cg.onlinetest.exceptions.NotAvailableException;
import com.cg.onlinetest.exceptions.UserIdException;

@RestControllerAdvice
public class ExamExceptionAdvice {
   Logger logger = LoggerFactory.getLogger(ExamExceptionAdvice.class);
	
   @ExceptionHandler({ExamException.class, UserIdException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ExamMessage handleException(Exception ex) {
	   logger.error(ex.getMessage());
		ExamMessage msg = new ExamMessage();
		msg.setMessage(ex.getMessage());
		return msg;
	}
	
	@ExceptionHandler({NotAvailableException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ExamMessage handleException2(Exception ex) {
		logger.error(ex.getMessage());
		ExamMessage msg = new ExamMessage();
		msg.setMessage(ex.getMessage());
		return msg;
	}
	
	@ExceptionHandler({LoginException.class})
	@ResponseStatus(code=HttpStatus.FORBIDDEN)
	public ExamMessage handleException3(Exception ex) {
		logger.error(ex.getMessage());
		ExamMessage msg = new ExamMessage();
		msg.setMessage(ex.getMessage());
		return msg;
	}
}
