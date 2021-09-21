package in.nit.healthcare.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.healthcare.entity.Specialization;


public class SpecializationExcelView extends AbstractXlsxView {


	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		    
//		1-SET FILE NAME
		response.addHeader("Content-Disposition", "attatchment;filename=SPECIALIZATION.xlsx");
		
//		2-READ SPECILIZATION DATA PROVIDED BY THE CONTROLLER
		List<Specialization> splList=(List<Specialization>)model.get("splList");
		
//		3-CREATE EXCEL SHEET
		Sheet sheet= workbook.createSheet("SPECIALIZATION");
		
//		4-SET ROW-0 AS EXCEL HEADER
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("NOTE");
		
//		5-FILL REMAINING ROWS WITH SPECIALIZATION DATA
		
		setExcelData(sheet,splList);
		
		   
		   
	}

	private void setExcelData(Sheet sheet, List<Specialization> splList) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(Specialization spl:splList) {
			Row row=sheet.createRow(rowNum);
			row.createCell(0).setCellValue(spl.getId());
			row.createCell(1).setCellValue(spl.getSpecCode());
			row.createCell(2).setCellValue(spl.getSpecName());
			row.createCell(3).setCellValue(spl.getSpecNote());
			rowNum++;
		}
		
	}

}
