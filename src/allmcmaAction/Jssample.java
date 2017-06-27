package allmcmaAction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import urls.urllink;

public class Jssample {
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		// TODO Auto-generated method stub
		JsonObject json = (JsonObject) new JsonParser().parse(new FileReader("ResultOfJson//assessments.json"));
		System.out.println(json);
		//JsonObject json = (JsonObject) new JsonParser().parse((String)response);
	}

}
