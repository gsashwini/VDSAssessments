package mainclass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import urls.ExcelReadWrite;
import urls.urllink;
import allmcmaAction.Assessment100Action;
///import allmcmaAction.HundredAssessment;
import allmcmaAction.HundredAssessmenta;
import allmcmaAction.MoreThenAskedForMcmaAction;
import allmcmaAction.StudentsLoginAction;
import allmcmaAction.TwoCorrectOneIncoorect;
import allmcmaAction.allmcmaassessmentsaction;
import allmcmaAction.test100code;
import allmcmaAction.trail;
//import allmcmaAction.trail;
import allmcmaAction.ZeroAssessmentsAction;


 
public class MainAllMcma {
    	
    	
private static WebDriver driver;
	
@BeforeClass
 public void setUp() throws Exception {
	 // DOMConfigurator.configure("log4j.xml");
	  System.setProperty("webdriver.firefox.marionette", "D:\\Softwares\\geckodriver.exe");
	  driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

@Test(priority=0) 
public void allmcmaassessment() throws Exception 
{
//	ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"StudentInformation-Sheet2");
//	String url=ExcelReadWrite.getCellData(1,2);
//	driver.get(url);
	
	driver.get(urllink.liferayUrl);

	Thread.sleep(5000);

	ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
	System.out.println("Login-Sheet1"+urllink.xcelFileName);
	

	StudentsLoginAction.studentlogin(driver);
	StudentsLoginAction.studentprofile(driver);
	
//allmcmaassessmentsaction.allmcmafunction(driver);
	//trail.allmcmafunction(driver);	
	//ZeroAssessmentsAction.executeSelectingExams(driver);
	test100code.executeSelectingExams(driver);
	//HundredAssessmenta.Hundreds(driver);
	//TwoCorrectOneIncoorect.TwoCorrectOneIncorrectAssessments(driver);
	//MoreThenAskedForMcmaAction.allmcmafunction(driver);
	//Assessment100Action.executeSelectingExams(driver);
	
}
}
