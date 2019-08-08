package com.TestNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExcelDataRead {

	public Object[][] obj ;

	@DataProvider(name="readData")
	public Object[][] accessData() throws IOException{
		obj = readExcelTestData();
		return obj;
	}

	@Test(dataProvider="readData")
	public void printTestdata(String UserName, String password){
		System.out.println(UserName + " | " + password);
	}

		
	public Object[][] readExcelTestData() throws IOException{
		String projectPath = System.getProperty("user.dir");
		XSSFWorkbook wb = new XSSFWorkbook(projectPath + "\\src\\com\\TestData\\TestData.xlsx");
		XSSFSheet sheet = wb.getSheet("Demo");
		//Get row count and column count
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		obj = new Object[rowCount][colCount];
		for(int i =0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				obj[i][j]= sheet.getRow(i).getCell(j).toString();
			}

		}

		return obj;
	}

}
