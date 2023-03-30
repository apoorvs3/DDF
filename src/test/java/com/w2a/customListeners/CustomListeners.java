package com.w2a.customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.base.TestBase;



public class CustomListeners  extends TestBase implements ITestListener{


	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed test: "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		/*
		 * Test-ng basic report
		 */
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"/Users/sinhapoo/git/DDF/_flag_ae.png\" target=\"_blank\">Screenshot link ----  </a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"/Users/sinhapoo/git/DDF/_flag_ae.png\" target=\"_blank\"><img height=200 width=200 src=\"/Users/sinhapoo/git/DDF/_flag_ae.png\"> </a>");
		System.out.println("capturing screenshot "+ result.getName());
	
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	}
	
}