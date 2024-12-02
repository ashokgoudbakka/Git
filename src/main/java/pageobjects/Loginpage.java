package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement mailAddressField;
	
	@FindBy(id="password")
	private WebElement passwordAddressField;
	
	@FindBy(name="submit")
	private WebElement loginbuttonAddressField;
	
	public WebElement mailAddressField() {
		return mailAddressField;
	}
	
	public WebElement passwordAddressField() {
		return passwordAddressField;
	}
		
		public WebElement loginbuttonAddressField() {
			return loginbuttonAddressField;

}
}
