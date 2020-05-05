package com.cg.onlinetest.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlinetest.entity.Questions;
import com.cg.onlinetest.service.IExamAdminService;

@RestController
public class QuestionFromExcelController {
	
    @Autowired
	private IExamAdminService service;

	@CrossOrigin
	@PostMapping("/upload")
	public String mapReapExcelDatatoDB(@RequestParam("qfile") MultipartFile reapExcelDataFile) throws IOException {

	   List<Questions> qlist = new ArrayList<Questions>();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
       Questions ques = null;
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	    	ques = new Questions();
	    	XSSFRow row = worksheet.getRow(i);
	        ques.setQuestionTitle(row.getCell(0).getStringCellValue());
	        ques.setOptA(row.getCell(1).getStringCellValue());
	        ques.setOptB(row.getCell(2).getStringCellValue());
	        ques.setOptC(row.getCell(3).getStringCellValue());
	        ques.setOptD(row.getCell(4).getStringCellValue());
	        ques.setAnswer(row.getCell(5).getStringCellValue());
	        ques.getExam().setExamId((int)row.getCell(6).getNumericCellValue());
	        qlist.add(ques);
	        
	    }
	    service.addQuestions(qlist);
	    return "File Uploaded Successfully";
	}


}
