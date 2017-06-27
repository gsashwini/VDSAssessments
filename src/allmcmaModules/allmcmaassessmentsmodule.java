package allmcmaModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import urls.ExcelReadWrite;
import urls.urllink;


public class allmcmaassessmentsmodule {
	static WebElement element = null;
	public static int q;
	public static WebElement Examselection(WebDriver driver, int elementCount){

		   
		element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/div[2]/a"));
		
		
	 System.out.println("Assignment selected"+element);
 
		return element;
		
}
public static int totalcheckbox(WebDriver driver){
    	

       int element = driver.findElements(By.xpath("//tr[*]/td/input")).size();

        return element;

        }
public static WebElement checkedmcma(WebDriver driver,int check){


	element = driver.findElement(By.xpath("//tr["+check+"]/td/input"));

	return element;

	}
public static WebElement nextbutton(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='next']"));

     return element;

     }
public static WebElement clickNext(WebDriver driver, int question){

element = driver.findElement(By.xpath("//*[@id='questionbartable']/tbody/tr/td["+question+"]"));

   return element;

}
public static WebElement takeexamlink(WebDriver driver){
	
  //  element = driver.findElement(By.linkText("Take Assessment"));
   // element = driver.findElement(By.xpath("//a[contains(text(),'Resume Assessment')]"));
    element = driver.findElement(By.xpath(".//*[@id='catalog_1']/tbody/tr/td[3]/div/div[1]/a"));

     return element;

     }
public static WebElement continuebutton(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='assessment-instructions']/form/input[3]"));

     return element;

     }
public static WebElement beginassessments(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='beginassessment']"));

     return element;

     }
public static boolean checkMCMA(WebDriver driver){

	boolean element = driver.findElements(By.xpath("//input[@type='CHECKBOX']")).size()>1;


	return element;

	} 
public static WebElement submit(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='submit']"));

     return element;

     }
public static int checkforquilet(WebDriver driver){
	

   int element = driver.findElements(By.xpath("//div/form/div")).size();

     return element;

     }
public static WebElement afterexamsubmit(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='submitButton']"));

     return element;

     }
public static int NoOfQuestions(WebDriver driver){
	

   int element = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();

     return element;

     }
public static WebElement chapterlanguage(WebDriver driver) throws Exception{
	

	   int languagesize = driver.findElements(By.xpath(".//*[@id='catalog_1']/tbody/tr[*]/td[1]/div")).size();
	//   System.out.println("languagesizelanguagesizelanguagesize "+languagesize);
	   for(int k=1;k<=languagesize;k++)
		{
		   ExcelReadWrite.setExcelFile(urllink.xcelPath + urllink.xcelFileName,"Login-Sheet1");
			String formlanguage = ExcelReadWrite.getCellData(10,1);
			
			// System.out.println("formlanguageformlanguageformlanguage    "+formlanguage);
			
		    String formnames =driver.findElement(By.xpath(".//*[@id='catalog_1']/tbody/tr["+k+"]/td[1]/div")).getText();
		    Thread.sleep(1000);
		    
		  //  System.out.println("formnamesformnamesformnames  "+formnames);

		    if(formnames.equals(formlanguage))
		    	
		    {
		    	q=k;
		    	//System.out.println("qqqqqqqqq "+q);
		    	//driver.findElement(By.xpath(".//*[@id='forms-table']/tbody/tr["+q+"]/td[1]/input"));
		    	driver.findElement(By.xpath(".//*[@id='catalog_1']/tbody/tr["+q+"]/td[1]/div")).getLocation();
		    	Thread.sleep(1000);
		   	element= driver.findElement(By.xpath(".//*[@id='catalog_1']/tbody/tr["+q+"]/td[3]/div/div[1]/a"));
		    	Thread.sleep(4000);
		    	//System.out.println("elementelementelementelementelement "+element);
		    	break;
		    }
		}
		return element;
		
		}
public static WebElement assessmentslink(WebDriver driver)
{
	 
element= driver.findElement(By.xpath("//a[contains(text(),'Assignments')]"));
    
    return element;
    }
public static int loadingPT(WebDriver driver){
	
	int element = driver.findElements(By.xpath(".//*[@id='loadingprogressbar']")).size();
	
    return element;
	
	}
public static WebElement skipPT(WebDriver driver){
	
	element = driver.findElement(By.xpath("//input[@id='skip']"));
	
    return element;
	
	}
public static WebElement question(WebDriver driver, int quest){
	
	   element = driver.findElement(By.xpath("//div["+quest+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[/]/td/div"));
		
	   return element;
		
		}
public static WebElement selectCourse(WebDriver driver){
	
	//element = driver.findElement(By.xpath("//div[@id='netacad-atlantic-view']/div[3]/div/div/a/div[2]/div[2]/div"));
	element = driver.findElement(By.xpath("//a/div[2]/div[2]/div[2]"));
    return element;

}
public static WebElement tkassessmentlink(WebDriver driver){
	
	//element = driver.findElement(By.xpath("//div[@id='netacad-atlantic-view']/div[3]/div/div/a/div[2]/div[2]/div"));
	element = driver.findElement(By.xpath(".//*[@id='catalog_1']/tbody/tr/td[3]/div/div[1]/a"));
    return element;

}

	     }
	

	


