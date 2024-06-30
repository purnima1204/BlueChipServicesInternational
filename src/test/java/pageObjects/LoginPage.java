package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Login button
	
		@FindBy(xpath="//a[@id='login-button']") WebElement LoginBtnbefore;
		
		
		// UserName
		
		@FindBy(xpath="//input[@id='Username']") WebElement userName;
		
		
		//Password
		
		@FindBy(xpath="//input[@id='password']") WebElement password;
		
		
		//submit
		
		@FindBy(xpath="(//button[normalize-space()='Login'])[1]") WebElement LoginBtnSubmit;
		
		
		
		
		
		public void clickLogin()
		{
			LoginBtnbefore.click();
		}
		
		
		public void setUsername(String name)
		{
			userName.sendKeys(name);
		}
		
		
		
		public void setPassword(String pwd)
		{
			password.sendKeys(pwd);
		}
		
		
		public void clickLoginBtn()
		{
			LoginBtnSubmit.click();
		}
		
		
		public void clickLoginBtnWithJS() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", LoginBtnSubmit);
		}
		
		public void scrollToLoginBtn() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", LoginBtnSubmit);
	    }
	

}
