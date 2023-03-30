package com.w2a.parameters;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class MultipleDp {


	@DataProvider(name = "dp1")
	public static Object[][] getData(Method m) {
		Object[][] data = null;
		if(m.getName().equalsIgnoreCase("testlogin")) {
			data = new Object[2][2];
			
			data[0][0] = "raman";
			data[0][1] = "haliflaila";
			
			
			data[1][0] = "Chaman";
			data[1][1] = "Sukhilal";
		}
		else if(m.getName().equalsIgnoreCase("testUserReg")) {
			data = new Object[2][3];
		
		data[0][0] = "raman";
		data[0][1] = "haliflaila";
		data[0][2] = "gmail";
		
		
		data[1][0] = "Chaman";
		data[1][1] = "Sukhilal";
		data[1][2] = "yahoo";
		}
		return data;
	}


}
