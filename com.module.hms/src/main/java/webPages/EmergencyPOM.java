package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.GenericMethods;

public class EmergencyPOM extends GenericMethods {
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Emergency Registration')]")
	private WebElement emergency;
	
	public WebElement getEmergency() {
		explicitWait(emergency);
		return emergency;
	}
	
	@FindBy(how=How.NAME,using="PATIENT_CAT")
	private WebElement patientcat;
	
	public WebElement getPatientCat() {
		
		return patientcat;
	}
	
	@FindBy(name="TITLE")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(how=How.NAME,using="PNT_NAME")
	private WebElement fName;
	
	public WebElement getFirstName() {
		
		return fName;
	}
	
	@FindBy(name="AGE")
	private WebElement AGE;
	
	public WebElement getAge() {
		return AGE;
	}
	
	@FindBy(how=How.NAME,using="SEX")
	private WebElement SEX;
	
	public WebElement getGender() {
		
		return SEX;
	}
	
	@FindBy(how=How.NAME,using="submit")
	private WebElement submit;
	
	public WebElement getSave() {
		
		return submit;
	}
	

}
