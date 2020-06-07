package com.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static String projectPath = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public String getFirstSentence(int rowNumber) {
		try {
				workbook = new XSSFWorkbook(projectPath+"/data/TestData.xlsx");
				sheet = workbook.getSheet("TestData");
				String inputData = sheet.getRow(rowNumber).getCell(rowNumber-1).getStringCellValue();
				//workbook.close(); 
				return inputData;
			}catch(Exception exp) {
				String message = "An exception has occured while accessing Excel Sheet: Here is the cause "+exp.getCause();
				return message;
		}
		
	}
	public String getSecondSentence(int rowNumber) {
		try {
				workbook = new XSSFWorkbook(projectPath+"/data/TestData.xlsx");
				sheet = workbook.getSheet("TestData");
				String inputData = sheet.getRow(rowNumber).getCell(rowNumber).getStringCellValue();
				//workbook.close();
				return inputData;
			}catch(Exception exp) {
				String message = "An exception has occured while accessing Excel Sheet: Here is the cause "+exp.getCause();
				return message;
		}
	}
	public String getExpectedResults(int rowNumber) {
		try {
				workbook = new XSSFWorkbook(projectPath+"/data/TestData.xlsx");
				sheet = workbook.getSheet("TestData");
				String inputData = sheet.getRow(rowNumber).getCell(rowNumber+1).getStringCellValue();
				//workbook.close();
				return inputData;
			}catch(Exception exp) {
				String message = "An exception has occured while accessing Excel Sheet: Here is the cause "+exp.getCause();
				return message;
		}
	}
}
