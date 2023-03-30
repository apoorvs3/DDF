package com.w2a.rough;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailureTests extends BaseTest{
	
	@Test
	public void failTest1() {
		Assert.fail();
	}
}
