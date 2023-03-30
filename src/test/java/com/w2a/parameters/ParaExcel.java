package com.w2a.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.utilities.ExcelReader;

public class ParaExcel {
	public static ExcelReader excel = null;
	
	@Test(dataProvider="getData")
	public void doLogin(String userName, String passsword, String is_correct) {
		System.out.println(userName + " ------ "+ passsword + " --------- "+ is_correct);
	}
	
	@DataProvider()
	public Object[][] getData() {
		//column in the Object array is same as the argument given for the data provider method
		
		if (excel== null) {
			excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		}
		String sheetName= "loginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];	//don't need heading
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			for(int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;		
	}
}
