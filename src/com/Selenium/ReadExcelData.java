package com.Selenium;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		//C:\Stuff\Reetu\WorkSpace\HelloWorld\src\com\TestData\TestData.xlsx
		
		String projectPath = System.getProperty("user.dir");
		//System.out.println(projectPath);
		XSSFWorkbook wb = new XSSFWorkbook(projectPath + "\\src\\com\\TestData\\TestData.xlsx");
		XSSFSheet sheet = wb.getSheet("Demo");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Row count===>" + rowCount);
		System.out.println("Column Count===>" + colCount);
		
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				System.out.println(sheet.getRow(i).getCell(j).toString());
			}
		}

	}

}
