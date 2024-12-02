  import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import basic.New;
import pageobjects.Homepage;
import pageobjects.Loginpage;

  
public class TestReal extends New{
	
	public WebDriver driver;
	
  @Test(dataProvider="logindata")
 
   public void TestTwo(String Email,String password) throws InterruptedException {
		
		
	
		Loginpage login = new Loginpage(driver);
		login.mailAddressField().sendKeys(Email);
		 login.passwordAddressField().sendKeys(password); 
		 login.loginbuttonAddressField().click();
		 
	
		 
		 // Hompage.......
		 
		
			  
		
		 Homepage home= new Homepage(driver);
		  
		 home.Arrowsymbol().click();
			 
		 Thread.sleep(3000);
		 
		 home.Manualattendance().click();
		 Thread.sleep(2000);
//		 	 
//		 home.DepartName("DEVELOPER").click();
//		 
//		 Thread.sleep(3000);
//           home.ShiftName("MORNING").click();
//		 Thread.sleep(4000);
//		 
//		home.EmployName("mahesh").click();
//		
//		 Thread.sleep(2000);
		 
//		 home.DateAttend().sendKeys(date);
//	
//	      home.Checkin().sendKeys(startTime);
//	      home.Checkout().sendKeys(endTime);
//	      
//	      home.Submit().click();
	}
	
	@ Test(priority=1,dataProvider="LocalData",invocationCount = 1)
	
	public void TestDemo(String date, String startTime,String endTime) throws InterruptedException {
		

		 Homepage home= new Homepage(driver);
		 
	 	 
			 home.DepartName("DEVELOPER").click();
			 
			 Thread.sleep(3000);
	           home.ShiftName("MORNING").click();
			 Thread.sleep(4000);
			 
			home.EmployName("githa2").click();
			
		
		 home.DateAttend().sendKeys(date);
			
	      home.Checkin().sendKeys(startTime);
	      home.Checkout().sendKeys(endTime);
	      
	    Thread.sleep(2000);
	      
	      home.Submit().click();
	    
	      try {
	            Thread.sleep(2000); // wait 2 seconds between submissions for demo purposes
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
     
		
    }

	
	 @BeforeClass
	 public void openApplication() throws IOException {
			 
		 
		driver= initializeDriver();
		// driver.get("https://attendance.smartattendancesystem.com/");
		 
		 driver.get("https://hrpayrollnew.smartattendancesystem.com/hrpayrollnew");
		
	 }
	 


	  @DataProvider(name="logindata")
	  
	 public Object[][] getlogindata() {
	 	   	return new  Object[][] {
	 	  {"Manoj","Manoj@2000"},

 	   	};
       }	   	
	 	   	
	 	   @DataProvider(name="LocalData")
	 		 public Object[][] getLocalData() throws Exception {
	 		 	   	return new  Object[][] {
	 		 	  {"04-11-2024","09.30","01.00"},
//	 		 	 
//	 		 	{"05-11-2024","6.30","19.00"},
//	 		 	{"06-11-2024","09.00","12.30"},
//	 		 	{"07-11-2024","09.00","19.30"},
	 		 {"16-11-2024","9.00","21.30"},
	 		 	{"17-11-2024","10.40","2.20"},
	 		 	   			 	 		 	
//	 		 	//  {"ashokgoudbakka507@gmail.com","Dream@8801"}
	 		 	  
 		 	   	}; 	
	}
	 		
  }





