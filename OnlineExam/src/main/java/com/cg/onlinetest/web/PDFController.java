package com.cg.onlinetest.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlinetest.dao.IExamDao;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class PDFController {
	
	@Autowired
	private IExamDao dao;
	
	@CrossOrigin
	@GetMapping("/viewpdf")
	public void downloadPdf( HttpServletResponse resp) {
		List<com.cg.onlinetest.entity.User>lst =dao.viewUsers();
	    Document document = new Document();
    try
    {
        PdfWriter writer = PdfWriter.getInstance(document, resp.getOutputStream());
        document.open();
        document.add(new Paragraph("List Of Users"));
        PdfPTable table = new PdfPTable(3); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table
 
        //Set Column widths
       // float[] columnWidths = {1f, 1f, 1f, 1f};
       // table.setWidths(columnWidths);
 
        PdfPCell cell1 = new PdfPCell(new Paragraph("User ID"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("User Name"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Role"));
        
        
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        for(com.cg.onlinetest.entity.User user: lst) {
        	cell1 = new PdfPCell(new Paragraph(user.getUserId()+""));
        	cell2 = new PdfPCell(new Paragraph(user.getUserName()));
        	cell3 = new PdfPCell(new Paragraph(user.getRole()+""));
        	table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
        }
        document.add(table);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	}

}
