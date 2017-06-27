package allmcmaModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoreThenAskedForMcmaModule {
	
private static final String Webdriver = null;
	
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
	
	public static WebElement listLanguageSelection(WebDriver driver,int d){


	element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+d+"]/td[1]"));
		
	return element;
		
	
}
	
	public static WebElement takeAssessment(WebDriver driver,int e){


    element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+e+"]/td[3]/div/div[1]/a"));
		
	return element;

	}
	
	public static WebElement clickContinue(WebDriver driver){


	    element = driver.findElement(By.xpath("//div[@id='assessment-instructions']/form/input[3]"));
			
		return element;

		}
	public static int numberofexams(WebDriver driver){


	   int element = driver.findElements(By.xpath("//li/div/div[2]/ul/li[*]/div")).size();
			
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
		
		element = driver.findElement(By.xpath("//table[@id='questionbartable']/tbody/tr/td["+question+"]"));
		
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

public static List<WebElement> checkbox(WebDriver driver){
	
	List<WebElement> element = driver.findElements(By.xpath("//input[@type='CHECKBOX']"));

	
   return element;
	
	}

public static WebElement selectCheckbox(WebDriver driver, int row){
	
	   element = driver.findElement(By.xpath("//tr["+row+"]/td/input"));
		
	   return element;
		
		}


public static WebElement inputText(WebDriver driver){
	
	   element = driver.findElement(By.xpath(".//*[@id='result_box']"));
		
	   return element;
		
		}
public static WebElement result(WebDriver driver){
	
	   element = driver.findElement(By.xpath(".//*[@id='result_box']"));
		
	   return element;
		
		}

public static WebElement question(WebDriver driver, int quest){
	
	   element = driver.findElement(By.xpath("//div["+quest+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[/]/td/div"));
		
	   return element;
		
		}
public static WebElement NoOfChecked(WebDriver driver, int n){
	
	   element = driver.findElement(By.xpath("//tr["+n+"]/td/input"));
		
	   return element;
		
		}
public static WebElement backtoassignment(WebDriver driver){
	
	   element = driver.findElement(By.xpath(".//*[@id='breadcrumbs']/ul/li[3]/a/span"));
		
	   return element;
		
		}


}
