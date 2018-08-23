package com.hms.registrations;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.ExcelReading;
import utilities.GenericMethods;
import webPages.EmergencyPOM;
import webPages.Home_POM;
import webPages.PerRegistration_POM;

public class Login extends GenericMethods {

	@Test(priority = 1,dataProviderClass = ExcelReading.class,dataProvider="hmsTestData")
	public void login(Map<String, String> map) {
		
		Home_POM home = PageFactory.initElements(driver, Home_POM.class);

		input(home.getUser(), map.get("UserName"), "User Name");
		input(home.getPassWord(), map.get("Password"), "Password");
		click(home.getLogin(), "SIgn In");
	}
	
	@Test(priority = 2,dataProviderClass = ExcelReading.class,dataProvider="hmsTestData")
	public void emergency(Map<String, String> map) {
			
		EmergencyPOM emergency = PageFactory.initElements(driver, EmergencyPOM.class);
		PerRegistration_POM perReg = PageFactory.initElements(driver, PerRegistration_POM.class);
		
		click(perReg.getRegistration(), "Registration");
		click(emergency.getEmergency(), "Emergency Registration");
		selectText(emergency.getPatientCat(),map.get("PatientCat"),"Patient Category");
		selectText(emergency.getTitle(), map.get("Title"), "Title");
		input(emergency.getFirstName(), map.get("FirstName"), "First Name");
		
		// click on save
		// accept alert
		
				
	}

}
