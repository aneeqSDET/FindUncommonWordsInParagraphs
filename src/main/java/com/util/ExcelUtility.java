package com.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static String projectPath = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public String getDataFromExcel(int rowNumber, int colNumber) {
		try {
				workbook = new XSSFWorkbook(projectPath+"/src/test/resources/TestCases/TestData.xlsx");
				sheet = workbook.getSheet("TestData");
				String inputData = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
				workbook.close();
				return inputData;
			}catch(Exception exp) {
				String message = "An exception has occured while accessing Excel Sheet: Here is the cause "+exp.getCause();
				return message;
		}
	}
}