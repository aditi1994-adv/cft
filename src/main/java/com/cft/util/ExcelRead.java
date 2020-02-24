package com.cft.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelRead {

	public static Iterator readExcel(MultipartFile imgpath) {
		
		byte[] str;
		try {
			str = imgpath.getBytes();
			XSSFWorkbook workbook = new XSSFWorkbook(new ByteArrayInputStream(str));

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator rows = sheet.rowIterator();	
			
			return rows;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
		
	}
	
	

}
