package com.w2a.rough;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTests extends BaseTest{
	
	@Test
	public void skipTest1() {
		throw new SkipException("skipiing as condition not met");
	}
}
