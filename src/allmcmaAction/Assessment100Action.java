package allmcmaAction;

import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Flash.FlashObjectWebDriver;
import allmcmaModules.Assessment100Module;
import allmcmaModules.AssessmentAt100;
import allmcmaModules.MoreThenAskedForMcmaModule;
import allmcmaModules.allmcmaassessmentsmodule;
import urls.AssessmentObj;
import urls.ExcelReadWrite;
import urls.JsonReader;
import urls.Log;
import urls.urllink;


public class Assessment100Action {
	
     public static int h = 1;
	
	 public static int i = 1;
	 
//	 public static int j = 0;
	 
	 public static String myQuestion;
	 
	 public static String myQuest;
	
	 static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
	  
//	  static ArrayList<AssessmentObj> questionList = new ArrayList<AssessmentObj>();
	  
//	  ArrayList<AssessmentObj> answerList = new ArrayList<AssessmentObj>();
	  
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
		
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
	   String numberOfCoursesInExams = ExcelReadWrite.getCellData(10,0);
	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
       Thread.sleep(5000);
       
	  
       for(h=7;h<=y;h++)
	   {
			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
			
//			String url_assign = driver.getCurrentUrl();
//			   String newurl = url_assign+"/assignments";
//			   System.out.println(driver.getCurrentUrl());
//			   driver.get(newurl);
//			   Thread.sleep(5000);
			Thread.sleep(5000);
			Assessment100Module.selectAssignment(driver,h).click();
			Thread.sleep(10000);
			
			driver.switchTo().frame(1);
		    
		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
			
		loopbreak:		
		for (int f=1;f<=languageSize;f++)
		{
			String lang= AssessmentAt100.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
		//	Log.info("language: "+lang);
				
			ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"LoginAndSettingInfo-Sheet1");
			String languageName = ExcelReadWrite.getCellData(10,1);

			if(lang.equals(languageName))
			{
				Assessment100Module.takeAssessment(driver, f).click();
				break loopbreak;
			}	
		}
						
			    driver.switchTo().activeElement();
			    Thread.sleep(1000);
			    
			    
			String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
				
			for (String windowHandle : handles) 
			{
			  if (!windowHandle.equals(parentWindow)) 
			  {
				driver.switchTo().window(windowHandle); 
				
				System.out.println("---------------------Begin Assessment------------------  ");
				
			    Assessment100Module.clickContinue(driver).click();
			    
			    Thread.sleep(1000);
			    
			    if(Assessment100Module.loadingPT(driver) > 0)
				{
				   Robot object=new Robot();
				   object.keyPress(KeyEvent.VK_DOWN);
				   object.keyRelease(KeyEvent.VK_DOWN);
				   Thread.sleep(3000);
				   System.out.println("Select Save File:");
				   Log.info("Select Save File:");
				   
				   object.keyPress(KeyEvent.VK_ENTER);
				   object.keyRelease(KeyEvent.VK_ENTER);
				    
				   Assessment100Module.skipPT(driver).click();
				   System.out.println("Skip Packet Tracer");
				   
				   Alert alert = driver.switchTo().alert();
				   driver.switchTo().alert();
				   alert.accept();
				   
				}
							
				else
				{
				   System.out.println("No packet tracer found");
				   Log.info("No packet tracer found");
				   Assessment100Module.clickBeginAssessment(driver).click();
				}  
			    
	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
		System.out.println("Number of Questions"+noOfQuestions);
		
				
for(i=1;i<=noOfQuestions;)
{
 
	JsonReader file = new JsonReader();
		    file.parseAssessments();
		    
		    AssessmentObj assessment = new AssessmentObj();
		    list.add(assessment);
		    
		    AssessmentObj assessment0 = list.get(0); 
		    ArrayList<String> ques = assessment0.getQuestion();
		    
		    int questSize = ques.size();
		    
//String tooltip = driver.findElement(By.xpath(".//*[@id='hovertext']")).getText();
//System.out.println("Tooltip is: " +tooltip);
		    
//    Actions builder = new Actions(driver);
//	WebElement tooltip1 = driver.findElement(By.xpath(".//*[@id='hovertext']"));
//	builder.clickAndHold(tooltip1).perform();
//	Thread.sleep(2000);
//	builder.release(tooltip1).perform();
//	String tooltip = tooltip1.getText();
//	System.out.println("Tooltip is: " +tooltip);
		    
    Thread.sleep(2000);
	String tooltip = driver.findElement(By.xpath(".//*[@class='ui-priority-primary']")).getText();
	System.out.println("Tooltip is: " +tooltip);
	

	if(Assessment100Module.checkFIB(driver))
    {
		
//		  Thread.sleep(3000);	
		
		System.out.println("inside if condition: ");
		
		String questFIB = Assessment100Module.questFIB(driver,i).getText().replace("\n","").replace("\r","").trim().replaceAll("\\s","");
		
		
		System.out.println("FIB Question is: "+questFIB);
		
	loopbreak:
	for(int j=0;j<questSize;j++)
	  {
		
		String jsonQues = ques.get(j).replace("\"","").replace(",","").replace(" \" ", "").trim().replaceAll("\\s","");
		//System.out.println("Print question from json: "+jsonQues);	
//		System.out.println("test: "+jsonQues.contains(questFIB));
		if(jsonQues.contains(questFIB))
		{
	    
	    System.out.println("Question found: "+jsonQues);
		ArrayList<String> corr = assessment.getCorrectAnswers();
		System.out.println("Correct Answer is: "+corr.get(j));
		
		String corrAns  = corr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
		String string = corrAns.split(",")[0].toString();
		
		driver.findElement(By.xpath("//input[@type='TEXT']")).clear();
		driver.findElement(By.xpath("//input[@type='TEXT']")).sendKeys(string);
		System.out.println("FIB answer: "+string);

		break loopbreak;
		
		}	
	
//		driver.quit();
	    }
		
	   
		System.out.println("Exit if condition: "+Assessment100Module.checkFIB(driver));
				
	  }
	

	  
	else 
{
		System.out.println("inside elseif condition: "+Assessment100Module.checkFIB(driver));
//		}
		String myQuest= driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().replace("\n","").replace("\r","");		
	//	System.out.println("Question: "+myQuest);
		
		int imageString = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
		//System.out.println("There is image: "+imageString);
		
		
//	    System.out.println("Question size is :" +questSize);
		
	    loop:
	    for(int j=0;j<questSize;j++)
	    {
	      
	     if(imageString>=1)
         {
		   
          String imgString = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
         // System.out.println("Image question: "+imgString);

          String myQuestion= myQuest.replace(imgString,"").trim();
      //    System.out.println("Question: "+myQuestion);
          
          if(ques.get(j).replace("\\","").contains(myQuestion))
		  {	    	 
		 //   System.out.println("Question found: " +ques.get(j)); 
			ArrayList<String> corr = assessment.getCorrectAnswers();
			//System.out.println("Correct Answer is: "+corr.get(j));
			
			String corrAns  = corr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
			
		    int correctAns = corrAns.split(",").length;
		//	System.out.println("No. of Correct Answers: "+correctAns);
			
			for(int p=0;p<correctAns;p++)
			{

			String string = corrAns.split(",")[p].toString();
		//	System.out.println("----String--- "+string);
			
			driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
		//	System.out.println("String click: "+string);
			}	
			 
			break  loop;
        }
         
        }
					     
		else
		{
			if(ques.get(j).replace("\\","").contains(myQuest))
			{
		    	  
			ArrayList<String> corr = assessment.getCorrectAnswers();
			//System.out.println("Correct Answer is: "+corr.get(j));
			
			String corrAns  = corr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
			
		    int correctAns = corrAns.split(",").length;
		//	System.out.println("No. of Correct Answers: "+correctAns);
			
			for(int p=0;p<correctAns; p++)
			{
				
			String string = corrAns.split(",")[p].toString();
			//System.out.println("----String--- "+string);
			
			driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
		//	System.out.println("String click: "+string);
			}	
			
			break;
		    }

		   }
		
	    }
		
	}
		    
	        i++;
			Assessment100Module.clickNext(driver,i).click();
			Thread.sleep(2000); 
//		} 
		}	

		Assessment100Module.clickSubmit(driver).click();
		Assessment100Module.gradeEvaluation(driver).click();
		driver.close();
	    driver.switchTo().window(parentWindow);
		}
					
	}
}
}

}