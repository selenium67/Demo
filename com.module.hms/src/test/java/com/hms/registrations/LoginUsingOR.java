package com.hms.registrations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.GenericMethods;

public class LoginUsingOR extends GenericMethods {

	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void hmslogin() throws Exception {

		driver.findElement(By.name(readProperty().getProperty("user"))).sendKeys("admin");
		driver.findElement(By.xpath(readProperty().getProperty("pass"))).sendKeys("admin");
		driver.findElement(By.xpath(readProperty().getProperty("login"))).click();
	}
}
