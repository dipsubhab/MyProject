package com.mercury.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class FileReading {
	
	static XSSFWorkbook workbook;
    static 
    XSSFSheet sheet;
    static Cell cell;
	
	public static List<List<String>> loginDataDriven(String filelocation, String sheetName) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(filelocation);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		List<List<String>> cred = null;
		
		List<String> dataCol1 = new ArrayList<>();
		List<String> dataCol2 = new ArrayList<>();
		
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
		String contentCol1 = sheet.getRow(i).getCell(0).getStringCellValue();
		dataCol1.add(contentCol1);
		
		String ContentCol2 = sheet.getRow(i).getCell(1).getStringCellValue();
		dataCol2.add(ContentCol2);
		
		cred = Arrays.asList(dataCol1, dataCol2);
		}
		return cred;
		
	}


}
