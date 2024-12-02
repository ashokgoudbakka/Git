package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class steetings {
	
	WebDriver driver;
	
	public steetings(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//*[@id=\"main-menu-wrapper\"]/ul/li[2]/a/span[2]")
	private WebElement clickarrow;
	
	@FindBy(xpath="//*[@id=\"main-menu-wrapper\"]/ul/li[2]/ul/li[2]/a")
	private WebElement shiftsee;
	

	public WebElement clickarrow() {
		return clickarrow;
	}
		
		public WebElement shiftsee() {
			return shiftsee;

		}
		
		@FindBy(xpath="//*[text()='577']")
		 WebElement DisplayT;
	
		

		public   String DisplayT() {
			return driver.findElement(By.xpath("//*[text()='577']")).getText();
		}
		
	
}
