package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentDashBoard extends BasePage{

	public StudentDashBoard(WebDriver driver) {
		super(driver);
	}
	
	
	//Toggle sideBar
	
	@FindBy(xpath=("//span[normalize-space()='Profile']")) WebElement profile;
	
	@FindBy(xpath=("//span[normalize-space()='Dashboard']")) WebElement Dashboard;
	
	@FindBy(xpath=("//span[normalize-space()='Services']")) WebElement Services;
	
	@FindBy(xpath=("//span[normalize-space()='Status']")) WebElement Status;
	
	@FindBy(xpath=("//span[normalize-space()='Schedule']")) WebElement Schedule;
	
	@FindBy(xpath=("//span[normalize-space()='Contact']")) WebElement Contact;
	
	@FindBy(xpath=("//button[normalize-space()='Edit Profile']")) WebElement EditProfileLink;
	
	@FindBy(xpath=("//input[@value='Save Changes']")) WebElement SaveChangesBtn;
	
	
	
	public void clickProfile()
	{
		profile.click();
	}
	
	public void clickDashboard()
	{
		Dashboard.click();
	}
	
	public void clickServices()
	{
		Services.click();
	}
	
	public void clickStatus()
	{
		Status.click();
	}
	
	public void clickSchedule()
	{
		Schedule.click();
	}
	
	public void clickContact()
	{
		Contact.click();
	}
	
	public void clickEditProfileLink()
	{
		EditProfileLink.click();
	}
	
	public void clickSaveChangesBtn()
	{
		SaveChangesBtn.click();
	}
	

}
