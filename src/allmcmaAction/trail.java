package allmcmaAction;



import org.openqa.selenium.By;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import urls.ExcelReadWrite;
import urls.Log;
import urls.urllink;


import allmcmaModules.MoreThenAskedForMcmaModule;
import allmcmaModules.allmcmaassessmentsmodule;

public class trail {

	private static WebDriver driver = null;
	
	
	
	public static void allmcmafunction(WebDriver driver) throws Exception 
	{
		
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
		String numberofcoursesinexams = ExcelReadWrite.getCellData(16,1);
		
		//Log.info("Number of courses	:     "+numberofcoursesinexams);
	//int y = Integer.parseInt(numberofcoursesinexams.trim()); 
	int y=MoreThenAskedForMcmaModule.numberofexams(driver);
	Thread.sleep(5000);
		for(int h=12;h<=y;h++)
		{
			
		allmcmaassessmentsmodule.Examselection(driver,h).click();
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		allmcmaassessmentsmodule.chapterlanguage(driver).click();
		
		
		
		 String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for ( String windowHandle : handles)
			{
				if (!windowHandle.equals(parentWindow)) 
				{
					driver.switchTo().window(windowHandle);
					Thread.sleep(1000);
					
					allmcmaassessmentsmodule.continuebutton(driver).click();
					
					 Thread.sleep(3000);
					    
					    if(allmcmaassessmentsmodule.loadingPT(driver)> 0)
						{
						   Robot object=new Robot();
						   object.keyPress(KeyEvent.VK_DOWN);
						   object.keyRelease(KeyEvent.VK_DOWN);
						   Thread.sleep(3000);
						   System.out.println("Select Save File:");
						   Log.info("Select Save File:");
						   
						   object.keyPress(KeyEvent.VK_ENTER);
						   object.keyRelease(KeyEvent.VK_ENTER);
						    
						   allmcmaassessmentsmodule.skipPT(driver).click();
						   System.out.println("Skip Packet Tracer");
						   
						   Alert alert = driver.switchTo().alert();
						   driver.switchTo().alert();
						   alert.accept();
						   
						}
									
						else
						{
						   System.out.println("No packet tracer found");
						   Log.info("No packet tracer found");
						   allmcmaassessmentsmodule.beginassessments(driver).click();
						  // AssessmentAt0.clickBeginAssessment(driver).click();
						}  
					
			int n = allmcmaassessmentsmodule.NoOfQuestions(driver);
			System.out.println("NoOfQuestions "+n);
			//int count =0;
	int j=1;
List <WebElement> listofItems=null;
for( int m=1;m<=n;m++)
{	
	
			if(allmcmaassessmentsmodule.checkMCMA(driver)== true)
			{
				
					String questiontext=allmcmaassessmentsmodule.question(driver,m).getText();
					System.out.println("QuestionText "+questiontext);
					ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
					String choosetwo = ExcelReadWrite.getCellData(10,2);;
					if(questiontext.contains (choosetwo))
					{
						 listofItems = driver.findElements(By.xpath("//input[@type='CHECKBOX']")); 
						 //System.out.print(" listofItems  "+listofItems +" size : " +listofItems.size());
						WebDriverWait wait = new WebDriverWait(driver, 20); //Wait time of 20 seconds
						for (int i=j; i<=j+2; i++) 
						{
							listofItems.get(i).click();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
							System.out.print(i + " element clicked\t--"); 
							System.out.println("pass");		
						}
						 allmcmaassessmentsmodule.nextbutton(driver).click();
						j=j+5;      
					} 
					     else
					    	 ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
							String choosethree = ExcelReadWrite.getCellData(10,3);
					    	 if(questiontext.contains(choosethree))
								{
								
								//for(int mc=0;mc<=2;mc++)
								//{
									 listofItems = driver.findElements(By.xpath("//input[@type='CHECKBOX']")); 
									// System.out.print(" listofItems  "+listofItems +" size : " +listofItems.size());
									WebDriverWait wait = new WebDriverWait(driver, 20); //Wait time of 20 seconds
									for (int i=j; i<=j+3; i++) 
									{
										listofItems.get(i).click();
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
										System.out.print(i + " element clicked\t--"); 				
									}
									 allmcmaassessmentsmodule.nextbutton(driver).click();
									j=j+6;      
								}
					    	 else
					    	 {
					    		 allmcmaassessmentsmodule.nextbutton(driver).click();
					    	 }
								     
								 //    System.out.println("JJJJJJJJJJ" +j);
								     Thread.sleep(1000);  
		
	}
			else
				if(allmcmaassessmentsmodule.checkforquilet(driver)!=0)
				{
					allmcmaassessmentsmodule.nextbutton(driver).click();
				}
	
			else
			{	
			allmcmaassessmentsmodule.nextbutton(driver).click();
			Thread.sleep(1000);
			System.out.print( " listofItems size "+listofItems); 
			}
		
	 System.out.print( " listofItems  "+listofItems);
	}
	allmcmaassessmentsmodule.submit(driver).click();
	allmcmaassessmentsmodule.afterexamsubmit(driver).click();
	driver.close();
	
    driver.switchTo().window(parentWindow);
    driver.switchTo().activeElement();
    allmcmaassessmentsmodule.assessmentslink(driver).click();					
					}	
	}
		}
		
		}
	}
//package allmcmaAction;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.List;
//import java.util.Set;
//
//
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import urls.ExcelReadWrite;
//import urls.urllink;
//import utility.Log;
//import utility.UrlXcelPath;
//import utility.XcelReadWrite;
//import allmcmaModules.MoreThenAskedForMcmaModule;
//
//public class MoreThenAskedForMcmaAction {
//	
//public static int h = 1;
//	
//	public static int i = 1;
//	
//	public static  void executeSelectingExams(WebDriver driver) throws Exception
//	{	
//		
//		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
//	   String numberOfCoursesInExams = ExcelReadWrite.getCellData(10,0);
//	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
//     int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
//     Thread.sleep(9000);
//     
//	  
//     for(h=2;h<=y;h++)
//	   {
//  	   
//			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
//			Thread.sleep(5000);
//			MoreThenAskedForMcmaModule.selectAssignment(driver, h).click();
//			Thread.sleep(10000);
//			
//			driver.switchTo().frame(1);
//		    
//		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
//			
//		loopbreak:		
//		for (int f=1;f<=languageSize;f++)
//		{
//			String lang= MoreThenAskedForMcmaModule.listLanguageSelection(driver,f).getText();
//			System.out.println("language: "+lang);
//			Log.info("language: "+lang);
//				
//			ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
//			String languageName = ExcelReadWrite.getCellData(10,1);
//
//			if(lang.equals(languageName))
//			{
//				MoreThenAskedForMcmaModule.takeAssessment(driver, f).click();
//				Thread.sleep(3000);
//				break loopbreak;
//			}	
//		}
//						
//			    driver.switchTo().activeElement();
//			    Thread.sleep(1000);
//			    System.out.println("Get window handle");    
//			    
//			    String parentWindow = driver.getWindowHandle();
//				Set<String> handles = driver.getWindowHandles();
//					
//	       for (String windowHandle : handles) 
//         {
//			
//	    	   if (!windowHandle.equals(parentWindow)) 
//			  {
//				driver.switchTo().window(windowHandle); 
//					
//				System.out.println("---------------------Begin Assessment------------------  ");
//					
//				MoreThenAskedForMcmaModule.clickContinue(driver).click();
//			    
//			    Thread.sleep(3000);
//				    
//			    
//			    if(MoreThenAskedForMcmaModule.loadingPT(driver) > 0)
//				{
//				   Robot object=new Robot();
//				   object.keyPress(KeyEvent.VK_DOWN);
//				   object.keyRelease(KeyEvent.VK_DOWN);
//				   Thread.sleep(3000);
//				   System.out.println("Select Save File:");
//				   Log.info("Select Save File:");
//				   
//				   object.keyPress(KeyEvent.VK_ENTER);
//				   object.keyRelease(KeyEvent.VK_ENTER);
//				    
//				   MoreThenAskedForMcmaModule.skipPT(driver).click();
//				   System.out.println("Skip Packet Tracer");
//				   
//				   Alert alert = driver.switchTo().alert();
//				   driver.switchTo().alert();
//				   alert.accept();
//				   
//				}
//							
//				else
//				{
//				   System.out.println("No packet tracer found");
//				   Log.info("No packet tracer found");
//				   MoreThenAskedForMcmaModule.clickBeginAssessment(driver).click();
//				}  
//			    
//	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
//		System.out.println("Number of Questions"+noOfQuestions);	   
//			   
//		for(i=1;i<=noOfQuestions;i++)
//		{
//			
////		int noOfCheckbox = driver.findElements(By.xpath("//tr[*]/td/input")).size();
////		System.out.println("No of check boxes" +noOfCheckbox);
//		
//		String readQuestion = MoreThenAskedForMcmaModule.question(driver,i).getText();
//		System.out.println("Question is:" +readQuestion);
//		
//		
//		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
//		String chooseTwo = ExcelReadWrite.getCellData(10,2);	
//		String chooseThree = ExcelReadWrite.getCellData(10,3);
//		Thread.sleep(3000);
//		
//		int choosemcma = driver.findElements(By.xpath("//tr[*]/td/input")).size();
//		
//		switch(readQuestion)
//		{
//		   case chooseTwo: if(readQuestion.contains(chooseTwo))		
//		   
//					Thread.sleep(3000);
//		
//			WebElement noOfCheckbox = driver.findElement(By.xpath("//tr[*]/td/input"));
//			System.out.println("No of check boxes" +noOfCheckbox);
//			List<WebElement> element = noOfCheckbox.findElements(By.xpath("//input[@type='CHECKBOX']"));
//
//			for (int j= 0; j <= 2; j++) {
//				  element.get(j).click();
//				}
//		   
//			break;
//					
//		   case chooseThree: if(readQuestion.contains(chooseThree)) 
//			
//			int noOfCheckboxes = driver.findElement(By.xpath("//tr[*]/td/input"));
//			System.out.println("No of check boxes" +noOfCheckboxes);
//			List<WebElement> element = noOfCheckboxes.findElements(By.xpath("//input[@type='CHECKBOX']"));
//
//			for (int j= 0; j <= 3; j++) {
//				  element.get(j).click();
//				}
//			
//			break;
//			
//		    
//	}
//			
//		MoreThenAskedForMcmaModule.clickNext(driver,i).click();
//		Thread.sleep(1000); 
//		 //else 
//		}	  
////window handle
//			
//		MoreThenAskedForMcmaModule.clickSubmit(driver).click();
//		MoreThenAskedForMcmaModule.gradeEvaluation(driver).click();
//		driver.close();
//	    driver.switchTo().window(parentWindow);
//		}
//					
//	}
//	}
//	}}


