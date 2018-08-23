package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_POM {
	
	@FindBy(how=How.NAME,using="username")
	private WebElement user;
	
	/*@FindBy(name="username")
	WebElement user1;*/
	
	public WebElement getUser() {
		
		return user;
	}
	
	@FindBy(how=How.XPATH,using="//input[@type='password']")
	private WebElement pass;
	
	public WebElement getPassWord() {
		return pass;
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Login']")
	private WebElement login;
	
	public WebElement getLogin() {
		
		return login;
	}
}
