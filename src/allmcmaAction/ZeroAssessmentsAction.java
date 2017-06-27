package allmcmaAction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import allmcmaModules.MoreThenAskedForMcmaModule;
import allmcmaModules.allmcmaassessmentsmodule;

import urls.ExcelReadWrite;
import urls.Log;
import urls.urllink;



public class ZeroAssessmentsAction {
	
	public static int h = 1;
	
	public static int i = 1;
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
       int y=MoreThenAskedForMcmaModule.numberofexams(driver);
       
	  othercourse:
       for(h=1;h<=y;h++)
	   {
			Thread.sleep(1000);
			
		String otherexam =MoreThenAskedForMcmaModule.selectAssignment(driver, h).getText();
		System.out.println("exammmmmmmmmmmmmmmmmmmmmm "+otherexam);
		if(otherexam.contains("Instructor Use Only")||otherexam.contains("PT"))
		{
			System.out.println("Course name is "+otherexam);
			continue othercourse;
			
		}
	
		MoreThenAskedForMcmaModule.selectAssignment(driver, h).click();
		driver.switchTo().frame(1);
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
				for( int m=0;m <=n;m++)
				{	

	
				allmcmaassessmentsmodule.nextbutton(driver).click();
				Thread.sleep(3000);		
	
	
}
				
allmcmaassessmentsmodule.submit(driver).click();
				
allmcmaassessmentsmodule.afterexamsubmit(driver).click();
driver.close();

driver.switchTo().window(parentWindow);
driver.switchTo().activeElement();
MoreThenAskedForMcmaModule.backtoassignment(driver).click();
					
				}	
}
	}
	
}
}

