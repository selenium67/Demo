package webPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Welcome_POM {
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Registration')]")
	private List<WebElement> registration;
	
	public List<WebElement> getRegistration(){
		
		return registration;
	}
	
	@FindBy(how=How.XPATH,using="//ul[@id='navigation']/li[1]/a")
	private WebElement reg;
	
	public WebElement getReg() {
		return reg;
		
	}

}
