package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PerRegistration_POM {
	
	@FindBy(how=How.NAME,using="PATIENT_CAT")
	private WebElement PATIENT;
	
	public WebElement getPatientCat() {
		
		return PATIENT;
	}
	
	@FindBy(how=How.NAME,using="image")
	private WebElement image;
	
	public WebElement getImage() {
		
		return image;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Registration")
	private WebElement Registration;
	
	public WebElement getRegistration() {
		
		return Registration;
	}
	

}
