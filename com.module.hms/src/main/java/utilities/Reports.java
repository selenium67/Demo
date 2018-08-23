package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reports {
	
	public static WebDriver driver = null;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports report;
	public static ExtentTest logger;
	public String timeStamp;
	public String reportPath;
	
	@BeforeTest
	public void startReport() {
		
		timeStamp = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss aa").format(Calendar.getInstance().getTime());
		reportPath = "./extentReports/"+timeStamp+".html";
		
		htmlreport = new ExtentHtmlReporter(reportPath);
		htmlreport.loadXMLConfig(new File("./Extent-Config.xml"));
		report = new ExtentReports();
		report.setSystemInfo("Operating System", "Windows");
		report.setSystemInfo("Domain", "Health Care");
		report.attachReporter(htmlreport);
		
	}
	
	@AfterTest
	public void endReport() {
		
		report.flush();
	}

}
