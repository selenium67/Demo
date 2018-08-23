package com.hms.registrations;



import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.GenericMethods;
import webPages.EmergencyPOM;
import webPages.Home_POM;

public class Emergency extends GenericMethods {
		
	@Test(priority=1)
	@Parameters({"user","pass"})
	public void login(String user,String pass) {
		
		logger = report.createTest("HMS User Login");
		Home_POM home = PageFactory.initElements(driver, Home_POM.class);

		input(home.getUser(), user, "UserName");
		input(home.getPassWord(), pass, "Password");
		driver.findElement(By.name("submit")).click();
	}
	
	@Test(priority=2)
	public void emergency() {
		logger = report.createTest("Emergency Registration");
		try {
			EmergencyPOM emergency = PageFactory.initElements(driver, EmergencyPOM.class);
					 
			driver.findElement(By.linkText("Registration")).click();
			emergency.getEmergency().click();
			new Select(emergency.getPatientCat()).selectByVisibleText("Self");
			new Select(emergency.getTitle()).selectByVisibleText("Ms.");
			emergency.getFirstName().sendKeys("Test");
			emergency.getAge().sendKeys("29");
			new Select(emergency.getGender()).selectByVisibleText("Male");
			click(emergency.getSave(), "Submit the Form");
			Thread.sleep(2000);
			acceptAlert("Confirmation");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=3)
	public void test3() {
		
		logger = report.createTest("Dummy Test 1");
		driver.findElement(By.xpath("test")).click();
		
	}
	
	@Test(priority=4)
	public void test4() {
		
		logger = report.createTest("Dummy Test 2");
	}

}
