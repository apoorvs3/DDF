package com.w2a.rough;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTests extends BaseTest{
	String expected = "yahoo";
	String actual = "google";
	
	@Test
	public void validateTitle() {
//		Assert.assertEquals(expected, actual);
//		Assert.fail("some message");
//		Assert.assertTrue(true, "fail because I have called it so");
		Assert.assertEquals(false, true, "some message I can put");
		System.out.println("will not reach here");
	}
	
	
	@Test
	public void softAssertion() {
		SoftAssert as = new SoftAssert();
		as.assertEquals(expected, actual);
		System.out.println("will reach here");
		as.assertAll();
	}
}
