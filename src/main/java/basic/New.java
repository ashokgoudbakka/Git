package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Loginpage;


public class New {
	

	WebDriver driver;
	
	
	public WebDriver  initializeDriver() throws IOException{
		
		Properties prop = new Properties();
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\basic\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
				prop.load(fis);
				
				 String browserName=prop.getProperty("browser");
				
		 
				 
				 
			//	 String browserName="chrome";
		 
		if(browserName.equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		  
		
	     }else
		 
		if(browserName.equalsIgnoreCase("firefox")) {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		  	
	}
		
		else if (browserName.equalsIgnoreCase("IE")) {
			   WebDriverManager.iedriver().setup();
			    driver=new InternetExplorerDriver();
			   }
		
		return driver;
	
	}
	
	
	public String TakeScreenShot(String testName,WebDriver driver) throws IOException {
		File Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(Source,new File(destinationFilePath));
	      return destinationFilePath;
	}
	
	
}

