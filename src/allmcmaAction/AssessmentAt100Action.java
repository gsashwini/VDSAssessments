//package allmcmaAction;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Set;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//import allmcmaModules.AssessmentAt100;
//import junit.framework.Assert;
////import module.AssessmentAt0;
////import module.AssessmentAt100;
////import module.AssessmentAtAllMcma;
////import utility.AssessmentObj;
////import utility.Log;
////import utility.ReadJson;
////import utility.UrlXcelPath;
////import utility.XcelRead;
//import urls.Parser;
//import urls.AssessmentObj;
//import urls.ExcelReadWrite;
//import urls.Log;
//import urls.urllink;
//
//public class AssessmentAt100Action {
//	
//     public static int h = 1;
//     public static String myQuest1;
//	 public static int i = 1;
//	 public static String myQuest123;
//	 public static String myQuest;
//	 static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
//	 
//	// public static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
//	
//	public static  void executeSelectingExams(WebDriver driver) throws Exception
//	{	
//		
//		ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
//	   String numberOfCoursesInExams = ExcelReadWrite.getCellData(10,0);
//	 //  Log.info("Number of courses	:     "+numberOfCoursesInExams);
//       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
//       Thread.sleep(5000);
//       
//	  
//       for(h=5;h<=y;h++)
//	   {
//			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
//			
////			String url_assign = driver.getCurrentUrl();
////			   String newurl = url_assign+"/assignments";
////			   System.out.println(driver.getCurrentUrl());
////			   driver.get(newurl);
////			   Thread.sleep(5000);
//			Thread.sleep(5000);
//			AssessmentAt100.selectAssignment(driver, h).click();
//			Thread.sleep(10000);
//			
//			driver.switchTo().frame(1);
//		    
//		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
//			
//		loopbreak:		
//		for (int f=1;f<=languageSize;f++)
//		{
//			String lang= AssessmentAt100.listLanguageSelection(driver,f).getText();
//			System.out.println("language: "+lang);
//			Log.info("language: "+lang);
//				
//			ExcelReadWrite.setExcelFile(urllink.xcelPath) + urllink.xcelFileName,"Login-Sheet1");
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
//	    
//	
//		int j=0;	   
//		for(i=1;i<=noOfQuestions;i++)
//		{
//			ReadJson test = new ReadJson();
//			   
//			list= test.parseAssessments();
//			  AssessmentObj assessment0 = list.get(0);
//			   System.out.println("next question");
//				ArrayList<String> ques = assessment0.getQuestion();
//				
//				int a = 0;
//				int assques = ques.size();
//				System.out.println("abcabcabc  before                 "+a);
//				//******************* Action for hover text
//				
////				 Actions ToolTip1 = new Actions(driver);
////				// Actions ToolTip2 = new Actions(driver);
////				   // WebElement ffiibb = driver.findElement(By.xpath("//div[@id='navbarhover']"));
////				    WebElement ffiibbspan = driver.findElement(By.xpath("//span[@id='hovertext']"));
////
////				    Thread.sleep(2000);
////
////				   //ToolTip1.clickAndHold(ffiibb).perform();
////				   // String ToolTipText = ffiibb.getAttribute("span");
////				    
////				 ToolTip1.clickAndHold(ffiibbspan).perform();
////				   String ToolTipTextspan = ffiibbspan.getText();
////				    
////				//    System.out.println("ToolTipTextToolTipTextToolTipTextToolTipText   "+ToolTipText);
////				    
////				    System.out.println("ToolTipTextToolTipspan  "+ToolTipTextspan);
//				
//				//int cur = driver.findElements(By.xpath("//*[@class='questions']")).size();
//				
//				//********************************
//				a = driver.findElements(By.xpath("//*[@class='question']/div[1]/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input[@type='TEXT']")).size();
//				System.out.println("abcabcabc    after               "+a);
//				//boolean isfound = false;
//			if(a>=1){
//				
////*********************************
//				
//				for(int m=0; m<=assques; m++)
//				{
//					//System.out.println("inside for");
//					//Thread.sleep(10000);
//					//String myQuestf = driver.findElement(By.xpath("//div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td")).getText().replace("+2s","").trim().replace("\n","").replace("\r","").replace("\"", "").replace(",", "");
//					String myQuestf = driver.findElement(By.xpath("//div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td")).getText();
//
//					//div["+a+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td
//					//String myQuestf = driver.findElement(By.xpath("//tr[2]/td")).getText();
//				//System.out.println("myQuestf found "+myQuestf);
//				
//				  String jsonQues = ques.get(m).replace("\"","").replace(",","").replace(" \" ", "").trim().replaceAll("\\s{2,}"," ");
//				
//				System.out.println("json question   "+jsonQues);
//				  String  questFIB = myQuestf.replace("\n","").replace("\r","").trim();
//				  System.out.println("questFIB question   "+questFIB);
//				  
//				if (jsonQues.contains(questFIB.trim()))
//				{
//					
//				ArrayList<String> corr = assessment0.getCorrectAnswers();
//				
//				String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\"", "");
//					
//					String s111 = corrans.split(",")[0].toString();
//					System.out.println("Answer is fib "+s111);
//					//System.out.println("Answer is  "+corrans.split(",")[j].toString());
//					
//					driver.findElement(By.xpath("//input[@type='TEXT']")).clear();
//					driver.findElement(By.xpath("//input[@type='TEXT']")).sendKeys(s111);
//				System.out.println("filled on answer");
//				//isfound=true;
//				break;
//				
//			//	*********************************
//				
//				}
//				
//				//else{System.out.println("not found in json answers");}
//				//break;
//			}
//			}
//			
//				else 
//				{
//					System.out.println("inside else");
//					System.out.println("inside else value of 1  "+1);
//			//String myQuest1 = driver.findElement(By.xpath("//tr[2]/td")).getText().replace("+2s","").trim().replace("\n","").replace("\r","").replace(" .","");
//			String myQuest1 = driver.findElement(By.xpath("html/body//div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().trim();
//			System.out.println("Question: from Assessment 1 "+myQuest1);
//			
//			
//  		//String myQuest = myQuest1.split("Refer to the exhibit").toString();
//			
//			
//			int yn = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
//			System.out.println("ynt "+yn);
//	
//			
//			
//			
//			   System.out.println("inside json");
//			   		    
//			 
//				//System.out.println("value of assquesassquesassquesm is    "+assques);
//				for(int m=0; m<=assques; m++)
//				{
//					// System.out.println("inside for");
//					if (yn >= 1)
//						
//					{		
//						String myQuest12 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
//					//	System.out.println("myQuest12myQuest12myQuest12myQuest12myQuest12  "+myQuest12);
//						String myQuest123 = myQuest1.replace(myQuest12,"");
//						//System.out.println("myQuest12my"+myQuest123);
//				
//				if (ques.get(m).replace("\\", "").contains(myQuest123.trim()))
//				{
//					System.out.println("inside if");
//				ArrayList<String> corr = assessment0.getCorrectAnswers();
//				
//				String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","");
//				
//				//String[] i2 = corrans.split("\",");
//				//int i1 = corrans.split("\",").length;
//				int i1 = corrans.split(",").length;
//				System.out.println(i1);
//
//				for(int j1=0;j1<i1; j1++)
//				{
//					String s = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\\u200B", "").replace("/", "");
//
//					//String s = corrans.split(",")[j1].toString().replace("\u200B", "");
//					System.out.println("Answer is  "+s);
//					//System.out.println("Answer is  "+corrans.split(",")[j].toString());
//					
//				
//				driver.findElement(By.xpath("//label[contains(.,'"+s+"')]")).click();
//				System.out.println("clicked on answer");
//				}
//								break;
//				}
//					}
//				else
//					
//				{	
//					
//					if (ques.get(m).replace("\\", "").contains(myQuest1))
//					{
//					System.out.println("QUESTIONQUESTION  FOUND"+ques.get(m));
//					ArrayList<String> corr = assessment0.getCorrectAnswers();
//					
//					String corrans = corr.get(m).replace("[" , "").replace("\"", "").replace("]","").replace("\\u200B", "");
//					
//					//String[] i2 = corrans.split("\",");
//					int i1 = corrans.split(",").length;
//					System.out.println(i1);
//
//					for(int j1=0;j1<i1; j1++)
//					{
//						
//						String s = corrans.split(",")[j1].toString();
//						System.out.println("Answer is  "+s);
//						//System.out.println("Answer is  "+corrans.split(",")[j].toString());
//						
//					Thread.sleep(5000);
//					driver.findElement(By.xpath("//label[contains(.,'"+s+"')]")).click();
//					System.out.println("clicked on answer");
//					}
//					
//					break;
//					}
//					
//				
//					}
//					}
//				
//				//******************************************************************
//				
//					
//				}
//				Thread.sleep(3000);
//				AssessmentAt100.clickNext(driver,i+1).click();
//			System.out.println("clicking on next next next ");
//		 
//			Thread.sleep(3000);
//		 
//		}  
//			
//		AssessmentAt100.clickSubmit(driver).click();
//		AssessmentAt100.gradeEvaluation(driver).click();
//		driver.close();
//	    driver.switchTo().window(parentWindow);
//		}
//					
//	}
//
//	}}
//}
//
////}