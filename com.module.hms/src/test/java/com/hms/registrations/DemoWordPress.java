package com.hms.registrations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.GenericMethods;

public class DemoWordPress extends GenericMethods {

	@Test
	public void wordPressLogin() {
		
		try {
			driver.findElement(By.id("user_login")).sendKeys("admin");
			driver.findElement(By.id("user_pass")).sendKeys("demo1234");
			driver.findElement(By.id("wp-submit")).click();
			
			try {		
				WebElement error = driver.findElement(By.id("login_error"));
				if (error.isDisplayed()) {
					String msg = error.getText();
					System.out.println("Login Failed due to "+msg);
				}
			} catch (Exception e) {				
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Here Write Take Screen Shot Code
		}
	}
	
}
