package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;

public class GenericMethods extends Reports {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browserName", "appURL" })
	public void setUp(String browser, String url) {

		getBrowser(browser);
		setURL(url);
	}
	
	@BeforeMethod
	public void createTestName(Method name) {
		
		logger = report.createTest(name.getName());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {

		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();
	}

	@AfterMethod
	public void verifyResults(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				logger.log(Status.PASS, "Test Method " + result.getTestClass().getName() + " is Successfully Executed");

			} else if (result.getStatus() == ITestResult.FAILURE) {

				String destination = System.getProperty("user.dir") + "/ScreenShots/" + timeStamp + " " + result.getName()
						+ ".png";
				TakesScreenshot src = (TakesScreenshot) driver;
				File source = src.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File(destination));
				
				logger.log(Status.FAIL,
						"Class Name is " + result.getTestClass().getName() + " And Method Name is "+ result.getName()+ " is Failed due to " + result.getThrowable()+
						logger.addScreenCaptureFromPath(destination));

			} else if (result.getStatus() == ITestResult.SKIP) {

				logger.log(Status.SKIP, result.getName() + "is Skipped due to " + result.getThrowable());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@AfterTest
	public void killSession() {

		try {
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void getBrowser(String browserName) {

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("ie")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver_win32/chromedriver.exe");
			driver = new InternetExplorerDriver();
		} else {

			System.out.println("Please Provide valid browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void setURL(String url) {

		if (url.equals("hms")) {
			driver.get("http://selenium4testing.com/hms/");
		} else if (url.equalsIgnoreCase("Amazon")) {

			driver.get("https://www.amazon.in");
		} else if (url.equalsIgnoreCase("wordPress")) {

			driver.get("http://demosite.center/wordpress/wp-login.php");
		}
	}

	public Properties readProperty() {

		try {
			File source = new File("./src/test/resources/OR.properties");
			FileInputStream fin = new FileInputStream(source);
			Properties prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public void click(WebElement element, String fieldName) {

		if (element.isDisplayed()) {
			element.click();
			logger.log(Status.INFO, "Clicked on " + fieldName);
		} else {
			Assert.fail(element + "is Not Available");
		}

	}

	public static void input(WebElement element, String testData, String fieldName) {

		if (element.isEnabled()) {

			element.clear();
			element.sendKeys(testData);
			logger.log(Status.INFO, "Entered the data in " + fieldName);
		} else {
			Assert.fail(element + "is Not Available");
		}
		
	}

	public void selectText(WebElement element, String testData, String fieldName) {

		if (element.isDisplayed()) {
			
			new Select(element).selectByVisibleText(testData);
			logger.log(Status.INFO, "Selected "+testData+" from "+fieldName);
		}else {
			
			Assert.fail("Unable to Select Value from "+fieldName);
		}
	}

	public void getText() {

		
	}
	
	public void explicitWait(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void acceptAlert(String fieldName) {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		logger.log(Status.INFO, "Successfully Accepted the Alert " + fieldName);
	}

}
