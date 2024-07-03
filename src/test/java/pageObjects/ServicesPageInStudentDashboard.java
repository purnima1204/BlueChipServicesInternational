package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicesPageInStudentDashboard extends BasePage{

	public ServicesPageInStudentDashboard(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(linkText="Services") WebElement servicesLink;
	
	@FindBy(xpath=("(//a[@class='btn btn-primary px-3'][normalize-space()='Learn More'])[5]")) WebElement Accommodation;
	
	@FindBy(xpath="(//button[normalize-space()='Request Appointment'])[1]") WebElement Appointment;
	
	//Form
	
	@FindBy(xpath=("//input[@id='name']")) WebElement name;
	
	@FindBy(xpath = ("//input[@id='number']")) WebElement number;
	
	@FindBy(xpath= ("//input[@id='email']")) WebElement email;
	
	@FindBy(xpath = ("//input[@id='message']")) WebElement message;
	
	@FindBy(xpath=("(//button[normalize-space()='Submit'])[1]")) WebElement submitButton;
	
	@FindBy(xpath="//img[@id='lanImage']") WebElement logo;
	
	@FindBy(xpath="//a[normalize-space()='Profile']") WebElement profileText;
	
	@FindBy(xpath="//span[normalize-space()='Services']") WebElement services;
	
	
	
	public void clickServiceslink()
	{
		servicesLink.click();
		
	}
	
	public void clickAccomodation()
	{
		Accommodation.click();
	}
	
	public void clickRequestAppointment()
	{
		Appointment.click();
	}
	
	
	
	public void setname(String Name)
	{
		name.sendKeys(Name);
	}
	
	public void setNum(String mobile)
	{
		number.sendKeys(mobile);
	}
	
	public void setMail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void setMessage(String msg)
	{
		message.sendKeys(msg);
	}
	
	public void clickSubmit()
	{
		submitButton.click();
	}
	
	public void clickLogo()
	{
		logo.click();
	}
	
	public void clickProfile()
	{
		profileText.click();
	}
	
	public void clickServices()
	{
		services.click();
	}
}
