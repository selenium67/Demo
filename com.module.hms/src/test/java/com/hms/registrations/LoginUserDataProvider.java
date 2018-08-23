package com.hms.registrations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Reports;

public class LoginUserDataProvider extends Reports {
	
	@DataProvider(name = "hms")
	public Object [][] setLoginData() {
		
		Object [][] obj = new Object [2][2];
		
		// 1st set of data
		obj[0][0] = "admin";
		obj[0][1] = "admin";
		
		// 2nd set of data
		obj[1][0] = "demo";
		obj[1][1] = "admin";
		
		return obj;
	}
	
	
	@Test(dataProvider = "hms" )
	public void login(String user,String pass) {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://selenium4testing.com/hms/");
		
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("submit")).click();
		
		
	}

}
