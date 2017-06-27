package allmcmaAction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import allmcmaModules.Assessment100Module;
import allmcmaModules.AssessmentAt100;
import junit.framework.Assert;
import urls.AssessmentObj;
import urls.ExcelReadWrite;
import urls.JsonReader;
import urls.Log;
import urls.urllink;


public class test100code {
	
     public static int h = 1;
     public static String myQuest1;
	 public static int i = 1;
	 public static String myQuest123;
	 public static String myQuest;
	 static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
	 static boolean dndchecked=false;
	 
	// public static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
		
		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
		String numberofcoursesinexams = ExcelReadWrite.getCellData(10,0);
		
		Log.info("Number of courses	:     "+numberofcoursesinexams);
		int y = Integer.parseInt(numberofcoursesinexams.trim()); 
       Thread.sleep(5000);
       
	  
       for(h=8;h<=y;h++)
	   {
			//driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
			
//			String url_assign = driver.getCurrentUrl();
//			   String newurl = url_assign+"/assignments";
//			   System.out.println(driver.getCurrentUrl());
//			   driver.get(newurl);
//			   Thread.sleep(5000);
			Thread.sleep(5000);
			AssessmentAt100.selectAssignment(driver, h).click();
			Thread.sleep(10000);
			
			driver.switchTo().frame(1);
		    
		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
			
		loopbreak:		
		for (int f=1;f<=languageSize;f++)
		{
			String lang= AssessmentAt100.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
			Log.info("language: "+lang);
				
			ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
			String languageName = ExcelReadWrite.getCellData(10,1);

			if(lang.equals(languageName))
			{
				AssessmentAt100.takeAssessment(driver, f).click();
				
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
				
			    AssessmentAt100.clickContinue(driver).click();
			    
			    Thread.sleep(1000);
			    
			    if(AssessmentAt100.loadingPT(driver) > 0)
				{
				   Robot object=new Robot();
				   object.keyPress(KeyEvent.VK_DOWN);
				   object.keyRelease(KeyEvent.VK_DOWN);
				   Thread.sleep(3000);
				   System.out.println("Select Save File:");
				   Log.info("Select Save File:");
				   
				   object.keyPress(KeyEvent.VK_ENTER);
				   object.keyRelease(KeyEvent.VK_ENTER);
				    
				   AssessmentAt100.skipPT(driver).click();
				   System.out.println("Skip Packet Tracer");
				   
				   Alert alert = driver.switchTo().alert();
				   driver.switchTo().alert();
				   alert.accept();
				   
				}
							
				else
				{
				   System.out.println("No packet tracer found");
				   Log.info("No packet tracer found");
				   AssessmentAt100.clickBeginAssessment(driver).click();
				}  
			    
	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
	
		
		int j=0;	   
		for(i=1;i<=noOfQuestions;i++)
		{
			JsonReader test = new JsonReader(); 
			 test.parseAssessments();
			 System.out.println("parsed json : "+ test);
			AssessmentObj assessment = new AssessmentObj();
		    list.add(assessment);
		    
			  AssessmentObj assessment0 = list.get(0);
			 
				ArrayList<String> ques = assessment0.getQuestion();
				
				int assques = ques.size();
				
				
				if(AssessmentAt100.DNDSkip(driver)==true)
				{
					
					System.out.println("DND question");
					AssessmentAt100.next(driver).click();
					Thread.sleep(2000);
					dndchecked =true;	
					
				}
				else
				{
				
			int	a = driver.findElements(By.xpath("//*[@class='question']/div[1]/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input[@type='TEXT']")).size();
			//	System.out.println("abcabcabc    after               "+a);
				//boolean isfound = false;
			if(a>=1)
			{
				
				for(int m=0; m<=assques; m++)
				{
						String myQuestf = driver.findElement(By.xpath("//div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td")).getText();

					
					String  questFIB = myQuestf.replace("\n","").replace("\r","").trim();
					
				//	System.out.println("assessment - After replacement "+questFIB);
				
				  String jsonQues = ques.get(m).replace("\"","").replace(",","").replace(" \" ", "").trim().replaceAll("\\s{2,}"," ").replace("\\", "").replace("\"", "").replace("]", "").replaceAll("]","");
				//System.out.println("BEfore replacement "+ques);
			System.out.println("json question   "+jsonQues);
			System.out.println("ASsessment question FIB "+questFIB);
				  
				if (jsonQues.contains(questFIB.trim()))
				{
					
				ArrayList<String> corr = assessment0.getCorrectAnswers();
				
				String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\"", "");
					
					String s111 = corrans.split(",")[0].toString();
				//	System.out.println("Answer is fib "+s111);
					
					Thread.sleep(2000);
					if(Assessment100Module.FIB(driver).isDisplayed())
					{
						System.out.println("Into FIB ");
					Assessment100Module.FIB(driver).clear();
					Assessment100Module.FIB(driver).sendKeys(s111);
					break;
					}
					else
					{
						
					}
				System.out.println("filled on answer");
			
				
				}
				else
				{
					System.out.println("FIB question not found");
					AssessmentAt100.next(driver).click();
					break;
				}
			
			}
			}
			
				else 
				{
					
					
			//String myQuest1 = driver.findElement(By.xpath("//tr[2]/td")).getText().replace("+2s","").trim().replace("\n","").replace("\r","").replace(" .","");
			String myQuest1 = driver.findElement(By.xpath("html/body//div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().trim();
			String PTq=myQuest1.replace("The PT initialization was skipped. You will not be able to view the PT activity.","").replace("\n","");
			//System.out.println("Assessment question PT "+PTq);
			//System.out.println("Question: from Assessment 1 "+myQuest1);
			
			int yn = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
			System.out.println("ynt "+yn);
	
			
				
				for(int m=0; m<=assques; m++)
				{
					
					if (yn >= 1)
						
					{		
						String myQuest12 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
					
						String myQuest123 = myQuest1.replace(myQuest12,"");
				if (ques.get(m).replace("\\", "").contains(myQuest123.trim()))
				{
					
				ArrayList<String> corr = assessment0.getCorrectAnswers();
				
				String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","");
				
				int i1 = corrans.split(",").length;
				

				for(int j1=0;j1<i1; j1++)
				{
					String s = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\\u200B", "").replace("/", "");

					//String s = corrans.split(",")[j1].toString().replace("\u200B", "");
					//System.out.println("Answer is  "+s);
					//System.out.println("Answer is  "+corrans.split(",")[j].toString());
					
				//driver.findElement(By.xpath("//label[contains(.,'"+s+"')]"));
				List<WebElement> tset = driver.findElements(By.xpath("//label[contains(.,'"+s+"')]"));
				int sizeofanswers=tset.size();
				int g=0;
				
				if (tset.get(g).isDisplayed())
				{
					tset.get(g).click();
					}
				else{
					
					while (!tset.get(g).isDisplayed())
					{
						g++;
					
					tset.get(g).click();
					}
					}
				
				//System.out.println("clicked on answer");
				}
								break;
				}
					}
				else
					
				{	
					
					String replacedquestion=ques.get(m).replace("\\", "").replace("\"", "").replace("]","").replace("[", "").replaceAll("\\s{2,}"," ");	
					//System.out.println("Question found "+replacedquestion);
					//System.out.println("Assessment question  "+PTq);
					if (replacedquestion.contains(PTq))
					{
						
					//System.out.println("QUESTIONQUESTION  FOUND"+ques.get(m));
					ArrayList<String> corr = assessment0.getCorrectAnswers();

					//System.out.println("corranscorranscorranscorranscorrans "+corr);
					
					String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\\u200B", "");
					
					
//					String[] i2 = corrans.split("\",");
//					int lenght1=i2.length;
//					System.out.println(" lenghtlenghtlenghtlenght "+lenght1);
				int i1 = corrans.split(",").length;
					int i3 = corrans.split("\"").length;
//				System.out.println("SIZE of answer i1 "+i1);
//				System.out.println("sixe of i3 "+i3);

					for(int j1=0;j1<i1; j1++)
					{
						
						String s = corrans.split(",")[j1].toString();
						System.out.println("Answers  "+s);
						String ss=s.replace("\\", "");
						
						//System.out.println("Answer is  "+corrans.split(",")[j].toString());
						
					Thread.sleep(4000);
					int g=0;
				//driver.findElement(By.xpath("//label[contains(.,'"+ss+"')]")).click();
					//driver.findElement(By.xpath("//*[contains(text(), '"+ss+"')]")).click();
					List<WebElement> answer=driver.findElements(By.xpath("//label[contains(.,'"+ss+"')]"));
					int answersizee=answer.size();
					//System.out.println("SIZE OF ANSWERS PRESENSCE "+answersizee);
					if(answer.get(0).isDisplayed())
					{
						answer.get(g).click();
					}
					else
					{
						for(int c=1;c<=answersizee;c++)
						{
					if (answer.get(c).isDisplayed())
					{
						answer.get(c).click();
						c++;					
					}
					break;
					}
					}

					}
					
					break;
					}
				}
				}
				}
				Thread.sleep(3000);
				//AssessmentAt100.clickNext(driver,i+1).click();
				AssessmentAt100.next(driver).click();
			//System.out.println("clicking on next next next ");
		 
			Thread.sleep(3000);
		 }
		}  
		if(dndchecked==true)
		{
			driver.switchTo().window(parentWindow).close();
			
		}
		else
		{
		AssessmentAt100.clickSubmit(driver).click();
		AssessmentAt100.gradeEvaluation(driver).click();
		driver.close();
	    driver.switchTo().window(parentWindow);
		}
			  }			
	}

	}
       }
}


//}
