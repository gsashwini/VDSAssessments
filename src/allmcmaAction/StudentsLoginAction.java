package allmcmaAction;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import urls.ExcelReadWrite;
import urls.Log;
import urls.urllink;


import allmcmaModules.StudentLoginModule;
import allmcmaModules.allmcmaassessmentsmodule;

public class StudentsLoginAction {

	public static void studentlogin(WebDriver driver) throws Exception{

		StudentLoginModule.LoginLink(driver).click();
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
		Thread.sleep(5000);
		String studentUsername=ExcelReadWrite.getCellData(2,0);
		System.out.println("studentUsernamestudentUsername "+studentUsername);
		StudentLoginModule.Username(driver).sendKeys(studentUsername);
		
		String studentPassword = ExcelReadWrite.getCellData(2,1);
		System.out.println("studentPasswordstudentPasswordstudentPassword "+studentPassword);
		StudentLoginModule.Password(driver).sendKeys(studentPassword);
		
		Thread.sleep(4000);
		
		StudentLoginModule.LoginButton(driver).click();
//		 ((JavascriptExecutor) driver).executeScript("scroll(0,250)");
//		   allmcmaassessmentsmodule.selectCourse(driver).click();
//	       Thread.sleep(3000);
		
		
	
}
	public static void studentprofile(WebDriver driver) throws Exception{
		String profile = driver.findElement(By.xpath(".//*[@id='banner-title']")).getText();
		  
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
		if(profile.contentEquals("My Profile")){
			  
			  String  goalExperience= ExcelReadWrite.getCellData(6,0);
			  System.out.println("Goal Experince is selected: "+goalExperience);
			  StudentLoginModule.selectGoal(driver).selectByVisibleText(goalExperience);
			  System.out.println("Goal Experince is selected: "+goalExperience);
			      Log.info("Goal Experince is selected: "+goalExperience);
			      Thread.sleep(2000);
			  
			  String  myExperience= ExcelReadWrite.getCellData(6,1);
			  StudentLoginModule.selectmyExperience(driver).selectByVisibleText(myExperience);
			      Log.info("IT Experince is selected: "+myExperience);
			      Thread.sleep(2000);
			       
			      String  gender= ExcelReadWrite.getCellData(6,2);
			      StudentLoginModule.selectGender(driver).selectByVisibleText(gender);
			      Log.info("Gender is selected: "+gender);
			      Thread.sleep(2000);
			       
			      String  race= ExcelReadWrite.getCellData(6,3);
			      StudentLoginModule.selectRace(driver).selectByVisibleText(race);
			      Log.info("Race is selected: "+race);
			      Thread.sleep(2000);
			       
			      String  militaryService= ExcelReadWrite.getCellData(6,4);
			      StudentLoginModule.selectMilitaryService(driver).selectByVisibleText(militaryService);
			      Log.info("Military Service is selected: "+militaryService);
			      Thread.sleep(2000);
			      
			      StudentLoginModule.nextButton(driver).click();
			 
			  }
			  
			  else
			  {
				   
				   ((JavascriptExecutor) driver).executeScript("scroll(0,250)");
				   allmcmaassessmentsmodule.selectCourse(driver).click();
			       Thread.sleep(3000);
			       String url_assign = driver.getCurrentUrl();
					String newurl = url_assign+"/assignments";
					driver.get(newurl);
			       
			      
			   } 
	}
}
			
		


	

