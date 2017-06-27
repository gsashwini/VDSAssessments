package allmcmaAction;



import org.openqa.selenium.By;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import urls.ExcelReadWrite;
import urls.urllink;


import allmcmaModules.allmcmaassessmentsmodule;

public class allmcmaassessmentsaction {

	private static WebDriver driver = null;
	
	
	
	public static void allmcmafunction(WebDriver driver) throws Exception 
	{
		
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
		String numberofcoursesinexams = ExcelReadWrite.getCellData(10,0);
		
		//Log.info("Number of courses	:     "+numberofcoursesinexams);
	int y = Integer.parseInt(numberofcoursesinexams.trim()); 
	Thread.sleep(5000);
		for(int h=9;h<=y;h++)
		{
			
		allmcmaassessmentsmodule.Examselection(driver,h).click();
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		allmcmaassessmentsmodule.chapterlanguage(driver).click();
		//allmcmaassessmentsmodule.tkassessmentlink(driver).click();
		
		
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
						   //Log.info("Select Save File:");
						   
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
						  // Log.info("No packet tracer found");
						   allmcmaassessmentsmodule.beginassessments(driver).click();
						  // AssessmentAt0.clickBeginAssessment(driver).click();
						}  
					
			int n = allmcmaassessmentsmodule.NoOfQuestions(driver);
			System.out.println("NoOfQuestions "+n);
					for( int m=0;m <=n;m++)
					{	
//if( allmcmaassessmentsmodule.nextbutton(driver).isEnabled())
//{
		if(allmcmaassessmentsmodule.checkMCMA(driver)== true)
		{
			
			
			List<WebElement> els = driver.findElements(By.xpath("//input[@type='CHECKBOX']"));
			
					for ( WebElement el : els ) {
			    if ( !el.isSelected() ) {
			        el.click();
			        Thread.sleep(1000);  		       
			    }     
			}
					allmcmaassessmentsmodule.nextbutton(driver).click();
					Thread.sleep(3000);		
		}
		else
		{
		allmcmaassessmentsmodule.nextbutton(driver).click();
		Thread.sleep(3000);
		}

	
	}
					
	allmcmaassessmentsmodule.submit(driver).click();
					
	allmcmaassessmentsmodule.afterexamsubmit(driver).click();
	driver.close();
	
    driver.switchTo().window(parentWindow);
    driver.switchTo().activeElement();
    allmcmaassessmentsmodule.assessmentslink(driver).click();
    Thread.sleep(3000);
	
						
					}	
	}
		}
		
	}
}

