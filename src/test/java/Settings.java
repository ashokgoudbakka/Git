import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basic.New;
import pageobjects.Loginpage;
import pageobjects.steetings;



public  class Settings extends New{
	
	public WebDriver driver;
	
	@Test(dataProvider="logindata")
	public void three(String Email,String password) throws IOException, InterruptedException {
		
		Thread.sleep(2000);
		Loginpage login = new Loginpage(driver);
		login.mailAddressField().sendKeys(Email);
		 login.passwordAddressField().sendKeys(password); 
		 login.loginbuttonAddressField().click();
		 
		 Thread.sleep(3000);
	


		
	//	Thread.sleep(2000);
		steetings st = new steetings(driver);
		
		    st.clickarrow().click();
       Thread.sleep(2000);		   
 		   st. shiftsee().click();
	   
		String actual=st.DisplayT() ;
		System.out.println(actual);
		
		String s = "577";
		
		assertEquals(actual,s);

	
	}


	 @BeforeClass
	 public void openApplication() throws IOException, InterruptedException {
			 
		 
		driver= initializeDriver();
		 driver.get("https://attendance.smartattendancesystem.com/");
		 
		Thread.sleep(2000);
		 
	 }
	
	  @DataProvider(name="logindata")
	 public Object[][] getlogindata() {
	 	   	return new  Object[][] {
	 	  {"Manoj","Manoj@2000"},
	 	   	};
	  }
	
	
	}

