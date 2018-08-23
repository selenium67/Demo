package com.hms.registrations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.GenericMethods;
import webPages.PerRegistration_POM;

public class PermanentRegistration extends GenericMethods {
	
	public String mrNo = null;
	
	@Test(priority=2,groups= {"Smoke"})
	public void permanentRegistration()throws Exception {
		
		PerRegistration_POM perReg = PageFactory.initElements(driver, PerRegistration_POM.class);
	
		String link = driver.findElement(By.linkText("Registration")).getText();	
		System.out.println(link);
		driver.findElement(By.linkText("Registration")).click();
		new Select(perReg.getPatientCat()).selectByVisibleText("Insurance");
		//new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Insurance");
		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Father");	
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Ms.");
		driver.findElement(By.name("PNT_NAME")).sendKeys("Marie");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("Voter ID");
		driver.findElement(By.name("LAST_NAME")).sendKeys("Gold");;
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345");
		driver.findElement(By.name("DOB")).sendKeys("12/12/1994");
		new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		driver.findElement(By.name("AGE")).sendKeys("19");
		new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("No");
		driver.findElement(By.name("AGE")).sendKeys("19");
		new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Female");
		new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("B.Sc");
		new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
		new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Employee");
		new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Hindu");
		new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("B+");
		new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("English");
		new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("No");	
		driver.findElement(By.name("ADDRESS1")).sendKeys("Hyderabad");
		driver.findElement(By.name("MOBILE_NO")).sendKeys("6789865443");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		driver.findElement(By.name("ZIP")).sendKeys("123456");
		
		click(perReg.getImage(), "Upload Image");
		
		
		Thread.sleep(2000);
		// To Execute .exe File we will use below code
		Runtime.getRuntime().exec("D:\\AutoIT\\hmsjuly.exe");
		WebElement save = driver.findElement(By.name("submit"));
		Thread.sleep(2000);
		save.click();
		// Navigate to Alert box
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String mrnumber = alert.getText();
		String mr[] = mrnumber.split(" ");
		System.out.println("Lenth of Registration Number is "+mr.length);
		mrNo = mr[4];
		System.out.println(mr[4]);
		// Perform the Action
		alert.accept();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,groups= {"Smoke","Hello"})
	public void emergencyRegistration() {
		
		System.out.println("Priority 3 value ");
	}
}
