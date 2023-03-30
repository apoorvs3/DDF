package com.w2a.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameter {
	
	@Test(dataProvider="getData")
	public void doLogin(String userName, String passsword) {
		System.out.println(userName + " "+ passsword);
	}
	
	@DataProvider()
	public Object[][] getData() {
		//column in the Object array is same as the argument given for the data provider method
		Object[][] data = new Object[3][2];
		data[0][0] = "email1";
		data[0][1] = "pass1";
		data[1][0] = "email2";
		data[1][1] = "pass2";
		data[2][0] = "email3";
		data[2][1] = "pass3";
		return data;		
	}
}
