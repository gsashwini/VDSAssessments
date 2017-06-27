package allmcmaModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assessment100Module {
	
private static final String Webdriver = null;

private static final String browser = null;
	
	static WebElement element= null;

	
	public static WebElement selectAssignment(WebDriver driver, int elementCount){
		   
		
	element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/div[2]/a"));
	
		
	 System.out.println("Assignment selected"+element);
 
		return element;
		
	}
	
	
	public static WebElement selectlanguage(WebDriver driver){
			   
			
	element = driver.findElement(By.xpath(""));
			
				
    System.out.println("Language selected"+element);
		 
	return element;
		

}
	public static WebElement FIB(WebDriver driver){
		   
		
		element = driver.findElement(By.xpath("//input[@type='TEXT']"));
		
		return element;
			

	}
	
	public static WebElement listLanguageSelection(WebDriver driver,int d){


	element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+d+"]/td[1]"));
		
	return element;
		
	
}
	
	public static WebElement takeAssessment(WebDriver driver,int e){


    element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+e+"]/td[3]/div/div[1]/a"));
		
	return element;

	}
	
	public static WebElement retakeAssessment(WebDriver driver,int e){


	    element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+e+"]/td[3]/div/div[2]/a"));
			
		return element;

		}
	public static WebElement clickContinue(WebDriver driver){


	    element = driver.findElement(By.xpath("//div[@id='assessment-instructions']/form/input[3]"));
			
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
	
	
	public static WebElement clickNext(WebDriver driver, int question){
		
		element = driver.findElement(By.xpath("//*[@id='questionbartable']/tbody/tr/td["+question+"]"));
		
	    return element;
		
		}
	
	
public static WebElement clickSubmit(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='submit']"));
		
	    return element;
		
		}

public static WebElement gradeEvaluation(WebDriver driver){
	
	element = driver.findElement(By.xpath("//input[@id='submitButton']"));
	
    return element;
	
	}

public static WebElement clickBeginAssessment(WebDriver driver){
	
	element = driver.findElement(By.xpath(".//*[@id='beginassessment']"));
	
    return element;
	
	}

public static WebElement clickAssignment(WebDriver driver){
	
	element = driver.findElement(By.xpath(".//*[@id='breadcrumbs']/ul/li[3]/a/span"));
	
    return element;
	
	}

public static int chapterList(WebDriver driver,int list1){

//  int	element = driver.findElements(By.xpath("//li["+list1+"]/div/div[2]/ul/li[*]/div/div/a")).size();
  
  int element = driver.findElements(By.xpath("//li["+list1+"]/div/div/div[2]/a")).size();
  
//  int element = driver.findElements(By.xpath("//li[*]/div/div/div[3]/a")).size();

	return element;

		}

public static WebElement chapterClicks(WebDriver driver,int list){


//	element = driver.findElement(By.xpath("//li["+chapterIndex+"]/div/div[2]/ul/li["+list+"]/div/div/div[3]"));

    element = driver.findElement(By.xpath("//li["+list+"]/div/div/div[2]/a"));	

//	element = driver.findElement(By.xpath("//li["+chapterIndex+"]/div/div[2]/ul/li["+list+"]/div/div/div[3]"));	
	return element;

	}

public static boolean checkFIB(WebDriver driver){
	
	boolean	element = driver.findElements(By.xpath("//*[@class='question']/div[1]/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input[@type='TEXT']")).size() >= 1;

			return element;

			}

public static boolean img(WebDriver driver, int i){


boolean element = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size()==1;

  return element;

}

public static int image(WebDriver driver,int k){

  int element = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+k+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();

  return element;

 }


public static WebElement questFIB (WebDriver driver, int a){

	  element = driver.findElement(By.xpath("//div["+a+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td"));
	
	  
//	  element = driver.findElement(By.xpath("//tr[2]/td"));
	  return element;

	 }


}