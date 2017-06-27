package allmcmaAction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import urls.AssessmentObj;
import urls.ExcelReadWrite;

import java.util.Set;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import allmcmaModules.MoreThenAskedForMcmaModule;
import allmcmaModules.allmcmaassessmentsmodule;
import urls.JsonReader;
import urls.Log;
import urls.urllink;


public class TwoCorrectOneIncoorect
{
	
	
	public static int h = 1;
	
	public static int i = 1;
	static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
	
	public static  void TwoCorrectOneIncorrectAssessments (WebDriver driver) throws Exception
	{	
	
       int y=MoreThenAskedForMcmaModule.numberofexams(driver);
       
	  othercourse:
       for(h=12;h<=y;h++)
	   {
			Thread.sleep(1000);
			
		String otherexam =MoreThenAskedForMcmaModule.selectAssignment(driver, h).getText();
		//System.out.println("exammmmmmmmmmmmmmmmmmmmmm "+otherexam);
		if(otherexam.contains("Instructor Use Only")||otherexam.contains("PT"))
		{
			//System.out.println("Course name is "+otherexam);
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
		
		for(i=1;i<=n;i++)
				{	
					
					//System.out.println("Inside Exam");
					Thread.sleep(1000);
					
					String questiontext=allmcmaassessmentsmodule.question(driver,i).getText();
				//	System.out.println("Assessment question "+questiontext);
					
					ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
					String choosethree = ExcelReadWrite.getCellData(10,3);
                    	if(allmcmaassessmentsmodule.checkMCMA(driver)== true && questiontext.contains(choosethree))
                    	{
					System.out.println("Insude MCMA");
					int yn = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
					System.out.println("ynt "+yn);
//					JavascriptExecutor js = (JavascriptExecutor)driver;
//					js.executeScript("JSON.parse('')");
					// read a file using javascript
					
					System.out.println("json object");
				
					JsonReader test =new JsonReader();
					test.parseAssessments();
					
					AssessmentObj assessment = new AssessmentObj();
				    list.add(assessment);
					AssessmentObj JsonQuestion=list.get(0);
					ArrayList<String> ques =JsonQuestion.getQuestion();
					System.out.println("Json question "+ques);
					int assques = ques.size();
					
					for(int m=0; m<=assques; m++)
					{
						System.out.println("No image 1");
						
						String jsonQues = ques.get(m).replace("\"","").replace(" \" ", "").trim().replaceAll("\\s{2,}"," ").replace("\\", "").replace("\"", "");
						System.out.println("jsonQues question "+jsonQues);
						if(jsonQues.replace("//", "").contains(questiontext) )
						{
							//System.out.println("No image question");
								ArrayList<String> corr =JsonQuestion.getCorrectAnswers();
								
								ArrayList<String> Incorr =JsonQuestion.getIncorrectAnswers();
								System.out.println("Correct answer "+corr.get(m));
								String CorrectAnswers=corr.get(m).toString().replace("[" , "").replace("]","").replace("\"", "");
								String IncorrectAnswer=Incorr.get(m).replace("[" , "").replace("]","").replace("\"", "");
								int numberofoptions = CorrectAnswers.split(",").length;
								
								for(int options=0;options <2;options++ )
								{
								String corectoptions1=CorrectAnswers.split(",")[options];
								System.out.println("corectoptions "+corectoptions1);
								List<WebElement> tset = driver.findElements(By.xpath("//label[contains(.,'"+corectoptions1+"')]"));
								int sizeofanswers=tset.size();
								int g=0;
								System.out.println("size "+sizeofanswers);
								for (g=0; g<=sizeofanswers;g++)
								{
									System.out.println("for g "+g);
								if (tset.get(g).isDisplayed())
								{
								System.out.println("gggggggg "+g);
									tset.get(g).click();
									break;
									}
								}
								
								}
								Thread.sleep(1000);
								String incorectoptions1=IncorrectAnswer.split(",")[0].toString();
								System.out.println("INcorectoptions "+incorectoptions1);
								List<WebElement> tset1 =	driver.findElements(By.xpath("//label[contains(.,'"+incorectoptions1+"')]"));
								int sizeofanswers=tset1.size();
								int g1=0;
								System.out.println("size "+sizeofanswers);
								for (g1=0; g1<=sizeofanswers;g1++)
								{
									System.out.println("for g "+g1);
								if (tset1.get(g1).isDisplayed())
								{
								System.out.println("gggggggg "+g1);
									tset1.get(g1).click();
									break;
									}
								}

							//	allmcmaassessmentsmodule.nextbutton(driver).click();
								
								break;
								}
						
						else
							if(yn>=1 )
							{
								//System.out.println("Image question");
								String myQuest12 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+m+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
								
								String myQuest123 = questiontext.replace(myQuest12,"");
							

								if(ques.get(m).replace("//", "").contains(myQuest123.trim()))
								{
									ArrayList<String> corr =JsonQuestion.getCorrectAnswers();
									ArrayList<String> Incorr =JsonQuestion.getIncorrectAnswers();
									
									System.out.println("Image question");
									System.out.println("Correct answer "+corr.get(m));
			                        
			                        
									String CorrectAnswers=corr.get(m).replace("[" , "").replace("]","").replace("\"", "");
									String IncorrectAnswer=Incorr.get(m).replace("[" , "").replace("]","").replace("\"", "");
									int numberofoptions = CorrectAnswers.split(",").length;
									
									for(int options=0;options <2;options++ )
									{
									String corectoptions1=CorrectAnswers.split(",")[options].toString();
									
									System.out.println("corectoptions "+corectoptions1);
									driver.findElement(By.xpath("//label[contains(.,'"+corectoptions1+"')]")).click();
									Thread.sleep(1000);
									}
									String incorectoptions1=IncorrectAnswer.split(",")[0].toString();
									
									driver.findElement(By.xpath("//label[contains(.,'"+incorectoptions1+"')]")).click();
									//allmcmaassessmentsmodule.nextbutton(driver).click();
									break;			
							}
								
							}
						
						}
		
					
                    	}
					
                    	allmcmaassessmentsmodule.nextbutton(driver).click();
					
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
	
	
	

