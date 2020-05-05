//package com.cg.onlinetest.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.onlinetest.dao.IExamDao;
//import com.cg.onlinetest.entity.ExamUserAssign;
//import com.cg.onlinetest.exceptions.NotAvailableException;
//
//@RestController
//public class ExamRestController {
//
//	@Autowired
//	private IExamDao dao;
//	
//	@CrossOrigin(origins= {"http://localhost:4200"})
//	@GetMapping(value="\"/viewexamhistory/{userId}")
//	public List<ExamUserAssign> getExamHistory(@PathVariable("userId") int userId) throws NotAvailableException {
//		
//	}
//	
//}
