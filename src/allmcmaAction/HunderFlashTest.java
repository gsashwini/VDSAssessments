//package allmcmaAction;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import urls.AssessmentObj;
//import urls.JsonReader;
//
//import java.util.Set;
//import org.junit.Test;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import com.google.gson.stream.JsonReader;
//
//import allmcmaModules.MoreThenAskedForMcmaModule;
//import allmcmaModules.allmcmaassessmentsmodule;
//import urls.Parser;
//import urls.Log;
//
//
//public class HundredAssessment 
//{
//	
//	
//	public static int h = 1;
//	
//	public static int i = 1;
//	static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
//	
//	public static  void Hundreds(WebDriver driver) throws Exception
//	{	
//	
//       int y=MoreThenAskedForMcmaModule.numberofexams(driver);
//       
//	  othercourse:
//       for(h=5;h<=y;h++)
//	   {
//			Thread.sleep(1000);
//			
//		String otherexam =MoreThenAskedForMcmaModule.selectAssignment(driver, h).getText();
//		System.out.println("exammmmmmmmmmmmmmmmmmmmmm "+otherexam);
//		if(otherexam.contains("Instructor Use Only")||otherexam.contains("PT"))
//		{
//			System.out.println("Course name is "+otherexam);
//			continue othercourse;
//			
//		}
//	
//		MoreThenAskedForMcmaModule.selectAssignment(driver, h).click();
//		driver.switchTo().frame(1);
//		allmcmaassessmentsmodule.chapterlanguage(driver).click();
//		
//		String parentWindow = driver.getWindowHandle();
//		Set<String> handles = driver.getWindowHandles();
//		for ( String windowHandle : handles)
//		{
//			if (!windowHandle.equals(parentWindow)) 
//			{
//				driver.switchTo().window(windowHandle);
//				Thread.sleep(1000);
//				
//				allmcmaassessmentsmodule.continuebutton(driver).click();
//				
//				 Thread.sleep(3000);
//				    
//				    if(allmcmaassessmentsmodule.loadingPT(driver)> 0)
//					{
//					   Robot object=new Robot();
//					   object.keyPress(KeyEvent.VK_DOWN);
//					   object.keyRelease(KeyEvent.VK_DOWN);
//					   Thread.sleep(3000);
//					   System.out.println("Select Save File:");
//					   Log.info("Select Save File:");
//					   
//					   object.keyPress(KeyEvent.VK_ENTER);
//					   object.keyRelease(KeyEvent.VK_ENTER);
//					    
//					   allmcmaassessmentsmodule.skipPT(driver).click();
//					   System.out.println("Skip Packet Tracer");
//					   
//					   Alert alert = driver.switchTo().alert();
//					   driver.switchTo().alert();
//					   alert.accept();
//					   
//					}
//								
//					else
//					{
//					   System.out.println("No packet tracer found");
//					   Log.info("No packet tracer found");
//					   allmcmaassessmentsmodule.beginassessments(driver).click();
//					  // AssessmentAt0.clickBeginAssessment(driver).click();
//					}  
//				
//		int n = allmcmaassessmentsmodule.NoOfQuestions(driver);
//		System.out.println("NoOfQuestions "+n);
//		loop:
//				for( int m=1;m <=n;m++)
//				{	
//					
//					System.out.println("Inside Exam");
//					Thread.sleep(1000);
//					JsonReader test =new JsonReader();
//					list=test.parseAssessments();
//					AssessmentObj JsonQuestion=list.get(0);
//					ArrayList<String> ques =JsonQuestion.getQuestion();
//					int assques = ques.size();
//					int a = driver.findElements(By.xpath("//*[@class='question']/div[1]/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input[@type='TEXT']")).size();
//					System.out.println("abcabcabc    after               "+a);
//					
//					String tooltip = driver.findElement(By.xpath(".//*[@id='hovertext']")).getText();
//					System.out.println("Tooltip is: " +tooltip);
//					
//					 if(tooltip.contains("SSAI"))
//					    {
//								
//							System.out.println("Drag and drop ");
//					
//					if(a>=1)
//					{
//					for(int jq=0; jq<=assques; jq++)
//					{
//						driver.findElement(By.xpath("//div["+jq+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td")).getText().replace("+2s","").trim().replace("\n","").replace("\r","").replace("\"", "").replace(",", "");
//						String myQuestf = driver.findElement(By.xpath("//div["+jq+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td")).getText();
//
//						  String jsonQues = ques.get(jq).replace("\"","").replace(",","").replace(" \" ", "").trim().replaceAll("\\s{2,}"," ");
//						
//						System.out.println("json question   "+jsonQues);
//						  String  questFIB = myQuestf.replace("\n","").replace("\r","").trim();
//						  System.out.println("questFIB question   "+questFIB);
//						  if (jsonQues.contains(questFIB.trim()))
//							{
//								
//							ArrayList<String> corr = JsonQuestion.getCorrectAnswers();
//							
//							String corrans = corr.get(jq).replace("[" , "").replace("\"", "").replace("]","").replace("\"", "");
//								
//								String s111 = corrans.split(",")[0].toString();
//								System.out.println("Answer is fib "+s111);
//								//System.out.println("Answer is  "+corrans.split(",")[j].toString());
//								
//								driver.findElement(By.xpath("//input[@type='TEXT']")).clear();
//								driver.findElement(By.xpath("//input[@type='TEXT']")).sendKeys(s111);
//							System.out.println("filled on answer");
//							//isfound=true;
//							break;
//							}
//					
//						
//							else 
//							{
//								System.out.println("inside else");
//								System.out.println("inside else value of 1  "+1);
//						
//						String myQuest1 = driver.findElement(By.xpath("html/body//div[1]/div[2]/div["+m+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().trim();
//						System.out.println("Question: from Assessment 1 "+myQuest1);
//						
//						int yn = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+m+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
//						System.out.println("ynt "+yn);
//						
//					if(yn>=1)
//					{
//						System.out.println("Image question");
//						String myQuest12 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+m+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
//						
//						String myQuest123 = myQuest1.replace(myQuest12,"");
//					
//					
//					if(ques.get(jq).replace("//", "").contains(myQuest123.trim()))
//					{
//						
//						
//						ArrayList<String> corr =JsonQuestion.getCorrectAnswers();
//						
//						System.out.println("Correct answer "+corr.get(jq));
//                        
//                        
//						String CorrectAnswers=corr.get(jq).replace("[" , "").replace("]","").replace("\"", "");
//						int numberofoptions = CorrectAnswers.split(",").length;
//						
//						for(int options=0;options <numberofoptions;options++ )
//						{
//						String corectoptions1=CorrectAnswers.split(",")[options].toString();
//						System.out.println("corectoptions "+corectoptions1);
//						driver.findElement(By.xpath("//label[contains(.,'"+corectoptions1+"')]")).click();
//						Thread.sleep(1000);
//						}
//					
//						break;
//					}
//						
//					}
//						
//						else
//						
//							if(ques.get(jq).replace("//", "").contains(myQuest1))
//							{
//								
//								ArrayList<String> corr =JsonQuestion.getCorrectAnswers();
//								
//								System.out.println("Correct answer "+corr.get(jq));
//		                        
//		                        
//								String CorrectAnswers=corr.get(jq).toString().replace("[" , "").replace("]","").replace("\"", "");
//								int numberofoptions = CorrectAnswers.split(",").length;
//								
//								for(int options=0;options <numberofoptions;options++ )
//								{
//								String corectoptions1=CorrectAnswers.split(",")[options];
//								System.out.println("corectoptions "+corectoptions1);
//								driver.findElement(By.xpath("//label[contains(.,'"+corectoptions1+"')]")).click();
//								Thread.sleep(1000);
//								}
//								
//								break;
//							}
//					
//					else
//					{
////					if(allmcmaassessmentsmodule.checkFIB(driver))
////					{
////						String questFIB = AssessmentAt100.questFIB(driver,i).getText().replace("\n","").replace("\r","").trim().replaceAll("\\s","");
////					}
//					}
//					allmcmaassessmentsmodule.nextbutton(driver).click();
//					
//				}
//				}
//					
//					
////allmcmaassessmentsmodule.submit(driver).click();
////				
////allmcmaassessmentsmodule.afterexamsubmit(driver).click();
//driver.close();
//
//driver.switchTo().window(parentWindow);
//driver.switchTo().activeElement();
//MoreThenAskedForMcmaModule.backtoassignment(driver).click();
//	
//}
//	}	
//}
//}
//	}
//	
//	//Choose two
//
//
//
//
//
