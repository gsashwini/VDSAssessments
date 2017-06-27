package allmcmaAction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Flash.FlashObjectWebDriver;
import allmcmaModules.MoreThenAskedForMcmaModule;
import allmcmaModules.allmcmaassessmentsmodule;
import urls.AssessmentObj;
import urls.JsonReader;
import urls.Log;


public class HundredAssessmenta
{
	
	
	public static int h = 1;
	
	public static int i = 1;
	static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
	
	
	public static  void Hundreds(WebDriver driver) throws Exception
	{	
		 String url_assign = driver.getCurrentUrl();
		String newurl = url_assign+"/assignments";
		driver.get(newurl);
		
       int y=MoreThenAskedForMcmaModule.numberofexams(driver);
       
	  othercourse:
       for(h=2;h<=y;h++)
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
	
				for( int m=1;m <=n;)
				{	
					
					System.out.println("Inside Exam");
					Thread.sleep(1000);
//					JsonReader test =new JsonReader();
//					list=test.parseAssessments();
					//AssessmentObj JsonQuestion=list.get(0);
					//ArrayList<String> ques =JsonQuestion.getQuestion();
					//int assques = ques.size();
//					int a = driver.findElements(By.xpath("//*[@class='question']/div[1]/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input[@type='TEXT']")).size();
//					System.out.println("abcabcabc    after               "+a);
//					Actions action = new Actions(driver);
//					WebElement element = driver.findElement(By.id("hovertext"));
//					String tooltip=driver.findElement(By.id("hovertext")).getText();
//					action.moveToElement(element).build().perform();
					String tooltip = driver.findElement(By.xpath(".//*[@id='hovertext']")).getText();
					System.out.println("Tooltip is: " +tooltip);
					
					 if(tooltip.contains("SSAI"))
					    {
//						 FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "AIit_274045Flash");		
//						 flashApp.callFlashObject("Play");
//						 Thread.sleep(5000);		
//							flashApp.callFlashObject("StopPlay");			
//							Thread.sleep(5000);	
//						 WebElement idd = driver.findElement(By.xpath(".//*[@id='AIit_274045Flash']"));
//						 System.out.println("iddd"+idd);
//							System.out.println("Drag and drop ");
//							 JavascriptExecutor js = (JavascriptExecutor)driver;	
//							// js.executeScript("alert(AIit_274045Flash);");
//							js.executeScript("window.document.AIit_274045Flash");
//							
//							var xmlInit = "AIit_274045Flash"><item id="undefined" reset="0"><observable name="obs1">1</observable><observable name="status">1,2,4</observable></item></assessment>";
//							setVariable(window.document.AIit_274045Flash,xmlInit);
//							((JavascriptExecutor) driver.executeScript("setTimeout(function({" +
//									"var xmlInit = AIit_274045Flash"><item id =" undefined " reset="0"><observable name="obs1">1</observable><observable name="status">1,2,4</observable></item></assessment>";"
//								            "var flashMovie=window.document.idd"+
//											"alert(flashmovie)"+
//								            "alert('this is a message'.(flashMovie.GetVariable('xmlOut')));"+
//											"}),1000);");
//							 Thread.sleep(10000L);
						 allmcmaassessmentsmodule.nextbutton(driver).click();
							
					    }
					
					 else
					 {
						 m++;
						 allmcmaassessmentsmodule.clickNext(driver,m).click();
					 }
				}
					
//allmcmaassessmentsmodule.submit(driver).click();
//				
//allmcmaassessmentsmodule.afterexamsubmit(driver).click();
driver.close();

driver.switchTo().window(parentWindow);
driver.switchTo().activeElement();
MoreThenAskedForMcmaModule.backtoassignment(driver).click();
	
}
	}	
		}
	   }
	}






