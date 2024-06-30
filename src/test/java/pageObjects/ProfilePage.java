package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	
	
	
	//ProfileLogo
	
	@FindBy(xpath="//img[@id='lanImage']") WebElement logo;
	
	//profile
	
	
	@FindBy(xpath="//a[normalize-space()='Profile']") WebElement profileText;
	
	
	//Logout
	
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement logoutBtn;
	
	
	public void clickLogo()
	{
		logo.click();
	}
	
	
	public void clickProfile()
	{
		profileText.click();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}
	
	
	
	public boolean isMyProfileexists()
	{
		try {
		return (profileText.isDisplayed());
	}catch(Exception e)
		{
		 return false;
		}

	}
}
