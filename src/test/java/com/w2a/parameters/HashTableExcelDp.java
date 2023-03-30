package com.w2a.parameters;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.utilities.ExcelReader;

public class HashTableExcelDp {
	public static ExcelReader excel = null;

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) {

		System.out.println(data.get("username") +"--------" + data.get("password") + "--------" + data.get("is_correct"));
		
	}

	// HashTable

	@DataProvider()
	public Object[][] getData() {
		// only 1 argument

		if (excel == null) {
			excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		}
		String sheetName = "loginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Hashtable<String, String> table = null;

		Object[][] data = new Object[rows - 1][1]; // don't need heading
		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0] = table;
			}
		}

		return data;
	}
}
