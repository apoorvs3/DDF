package com.w2a.parameters;

import org.testng.annotations.Test;

public class ExplicitDp {

	@Test(dataProvider = "dp1", dataProviderClass = MultipleDp.class)
	public void testlogin(String userName, String password) {
		System.out.println(userName + "----" + password);
	}

	@Test(dataProvider = "dp1", dataProviderClass = MultipleDp.class)
	public void testUserReg(String fname, String lname, String email) {
		System.out.println(fname + "----" + lname + "-----" + email);
	}
}
