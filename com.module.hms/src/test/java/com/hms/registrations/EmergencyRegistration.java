package com.hms.registrations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.GenericMethods;
import utilities.ReadData;
import webPages.EmergencyPOM;
import webPages.Home_POM;

public class EmergencyRegistration extends GenericMethods {
		
	@Test(priority=1)
	@Parameters({ "userName", "password" })
	public void login(String user,String pass) {
		
		Home_POM home = PageFactory.initElements(driver, Home_POM.class);

		input(home.getUser(), user, "UserName");
		input(home.getPassWord(), pass, "Password");
		driver.findElement(By.name("submit")).click();
	}
	
	@Test(priority=2,dataProviderClass=ReadData.class,dataProvider="hms")
	public void emergency(Map<String, String> data) {
		
		try {
			EmergencyPOM emergency = PageFactory.initElements(driver, EmergencyPOM.class);
					 
			driver.findElement(By.linkText("Registration")).click();
			emergency.getEmergency().click();
			new Select(emergency.getPatientCat()).selectByVisibleText(data.get("PatientCat"));
			new Select(emergency.getTitle()).selectByVisibleText("Ms.");
			emergency.getFirstName().sendKeys("Test");
			emergency.getAge().sendKeys("29");
			new Select(emergency.getGender()).selectByVisibleText("Male");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
