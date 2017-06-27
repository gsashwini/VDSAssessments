//package action;
//
//import java.awt.List;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import java.util.Set;
//
//import org.json.simple.JSONObject;
//import org.junit.Assert;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//import Flash.FlashObjectWebDriver;
//import module.AssessmentAt0;
//import module.AssessmentAt100;
//import utility.AssessmentObj;
//import utility.Log;
//import utility.ReadJson;
//import utility.UrlXcelPath;
//import utility.XcelRead;
//
//public class trail{
//	
//private static final String GREEN = null;
//
//	//	private static String GREEN = "GREEN";
//     public static int h = 1;
//	
//	 public static int i = 1;
//	 
////	 public static int j = 0;
//	 
//	 public static String myQuestion;
//	 
//	 public static String myQuest;
//	
//	 static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
//	  
////	  static ArrayList<AssessmentObj> questionList = new ArrayList<AssessmentObj>();
//	  
////	  ArrayList<AssessmentObj> answerList = new ArrayList<AssessmentObj>();
//	  
//	
//	
//	public static  void executeSelectingExams(WebDriver driver) throws Exception
//	{	
//		
//	   XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
//	   String numberOfCoursesInExams = XcelRead.getCellData(10,0);
//	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
//       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
//       Thread.sleep(5000);
//       
//	  
//       for(h=1;h<=y;h++)
//	   {
//			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
//			
////			String url_assign = driver.getCurrentUrl();
////			   String newurl = url_assign+"/assignments";
////			   System.out.println(driver.getCurrentUrl());
////			   driver.get(newurl);
////			   Thread.sleep(5000);
//			Thread.sleep(5000);
//			AssessmentAt100.selectAssignment(driver,h).click();
//			Thread.sleep(10000);
//			
//			driver.switchTo().frame(1);
//		    
//		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
//			
//		loopbreak:		
//		for (int f=1;f<=languageSize;f++)
//		{
//			String lang= AssessmentAt0.listLanguageSelection(driver,f).getText();
//			System.out.println("language: "+lang);
//		//	Log.info("language: "+lang);
//				
//			XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
//			String languageName = XcelRead.getCellData(10,1);
//
//			if(lang.equals(languageName))
//			{
//				AssessmentAt100.takeAssessment(driver, f).click();
//				break loopbreak;
//			}	
//		}
//						
//			    driver.switchTo().activeElement();
//			    Thread.sleep(1000);
//			    
//			    
//			String parentWindow = driver.getWindowHandle();
//			Set<String> handles = driver.getWindowHandles();
//				
//			for (String windowHandle : handles) 
//			{
//			  if (!windowHandle.equals(parentWindow)) 
//			  {
//				driver.switchTo().window(windowHandle); 
//				
//				System.out.println("---------------------Begin Assessment------------------  ");
//				
//			    AssessmentAt100.clickContinue(driver).click();
//			    
//			    Thread.sleep(1000);
//			    
//			    if(AssessmentAt100.loadingPT(driver) > 0)
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
//				   AssessmentAt100.skipPT(driver).click();
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
//				   AssessmentAt100.clickBeginAssessment(driver).click();
//				}  
//			    
//	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
//		System.out.println("Number of Questions"+noOfQuestions);
//		
//				
//for(i=1;i<=noOfQuestions;)
//{
// 
//			ReadJson file = new ReadJson();
//		    file.parseAssessments();
//		    
//		    AssessmentObj assessment = new AssessmentObj();
//		    list.add(assessment);
//		    
//		    AssessmentObj assessment0 = list.get(0); 
//		    ArrayList<String> ques = assessment0.getQuestion();
//		    
//		    int questSize = ques.size();
//		    
//String tooltip = driver.findElement(By.xpath(".//*[@id='hovertext']")).getText();
//System.out.println("Tooltip is: " +tooltip);
//		    
////    Actions builder = new Actions(driver);
////	WebElement tooltip1 = driver.findElement(By.xpath(".//*[@id='hovertext']"));
////	builder.clickAndHold(tooltip1).perform();
////	Thread.sleep(2000);
////	builder.release(tooltip1).perform();
////	String tooltip = tooltip1.getText();
////	System.out.println("Tooltip is: " +tooltip);
////		    
////    Thread.sleep(2000);
////	String tooltip = driver.findElement(By.xpath(".//*[@class='ui-priority-primary']")).getText();
////	System.out.println("Tooltip is: " +tooltip);
//	
//
//	 if(tooltip.contains("SSAI"))
//    {
//			
//		System.out.println("Drag and drop ");
//		
//		//FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "AIit_274045Flash");
//		 
////		 driver.get(URL);
//		 
//		 //Assert.assertEquals("Clicking Colors", driver.getTitle());
//		 
//		// Assert.assertNotNull(flashApp.callFlashObject("play"));
//		String flashId = "xmlOut";
//		((JavascriptExecutor) driver).executeScript("setTimeout(function(){" +
//            "var flashMovie=getFlashMovieObject();"+
//            "console.log(flashMovie.GetVariable('xmlOut'));"+
//				"},1000);");
//		
//
//		 //flashApp.callFlashObject("click");
//		 Thread.sleep(10000L);
////		 Assert.assertEquals(BLUE, flashApp.callFlashObject("getColor"));
////		 flashApp.callFlashObject("click");
////		 Thread.sleep(10000L);
////		 Assert.assertEquals(RED, flashApp.callFlashObject("getColor"));
////		 flashApp.callFlashObject("click");
////		 Thread.sleep(10000L);
////		 Assert.assertEquals(GREEN, flashApp.callFlashObject("getColor"));
//		 
////		 driver.quit();
//		 }
//		 
//		 
////		}
////    }
//	 else{
//		     i++;
//	       
//			AssessmentAt100.clickNext(driver,i).click();
//			Thread.sleep(2000); 
//
//		}
//			}		
//		
////		AssessmentAt100.clickSubmit(driver).click();
////		AssessmentAt100.gradeEvaluation(driver).click();
//		driver.close();
//	    driver.switchTo().window(parentWindow);
//		}
//					
//	}
//}
//}}
//
//
