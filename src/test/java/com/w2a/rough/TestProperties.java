package com.w2a.rough;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) {
		try {
			Properties config = new Properties();
			Properties or = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/resources/properties/config.properties");
			config.load(fis);
			System.out.println(config.getProperty("testsiteurl"));
		}
		catch (Exception e){
			
		}
		
	}
}
