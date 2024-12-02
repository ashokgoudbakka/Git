package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	
WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="//*[@id=\"main-menu-wrapper\"]/ul/li[4]/a/span[1]")
	private WebElement Arrowsymbol;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/ul/li[4]/ul/li[2]/a")
	private WebElement Manualattendance;
	

	@FindBy(id="departments")
	private WebElement DepartName;
//	
	@FindBy(id="shiftname")
	private WebElement ShiftName;
//	
	@FindBy(id="employees")
	private WebElement EmployName;
	
	
	@FindBy(xpath="//*[@id=\"myForm\"]/div/div[1]/div[4]/div[1]/div/div/input")
	private WebElement DateAttend;
	

	public WebElement Arrowsymbol() {
		return Arrowsymbol;
	}
	
	public WebElement Manualattendance() {
		return Manualattendance;
	}
	
	
	public WebElement DepartName(String option){

		Select s =new Select (DepartName);
				s.selectByVisibleText(option);
				return DepartName;
			}
//
//			
//			
			public  WebElement ShiftName(String option) {
				Select s =new Select (ShiftName);
				s.selectByVisibleText(option);
				return ShiftName;
				
			}
//			
			public  WebElement EmployName(String option) {
				Select s =new Select (EmployName);
				s.selectByVisibleText(option);
				return EmployName;
				
			}
			
		
		public WebElement DateAttend() {
			return DateAttend;

		}
		@FindBy(id="timeInput")
		private WebElement Checkin;
		
		
		@FindBy(id="timeInputcheckout")
		private WebElement Checkout;
		
		@FindBy(name="submit")
		private WebElement Submit;
		
		public WebElement Checkin() {
			return  Checkin;
		}
		
		public WebElement Checkout() {
			return  Checkout;
		}
		
		public WebElement Submit() {
			return Submit;
		}
		
		
		
}
