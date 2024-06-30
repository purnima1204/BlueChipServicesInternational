package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);

	}

	// RegisterNow Button

	@FindBy(linkText = "Register Now") WebElement registerBtn;


	// Register AS Student

	@FindBy(xpath = "//div[contains(text(),'Student')]") WebElement StudentBtn;


	//Name

	@FindBy(xpath="//input[@placeholder='Your Name']") WebElement nameInputfield;


	//phoneNumber

	@FindBy(xpath= "//input[@placeholder='Phone Number']") WebElement phoneNum;

	//Email

	@FindBy(xpath= "//input[@placeholder='Email Address']") WebElement myemail;

	//password

	@FindBy(xpath = "(//input[@placeholder='Enter your password'])[1]") WebElement pwd;

	// countryName

	@FindBy(xpath ="//input[@placeholder='Enter Country Name']") WebElement countryname;


	// Address

	@FindBy(xpath="//input[@placeholder='Enter Address']") WebElement address;


	// submitBtn

	@FindBy(xpath="//button[@type='submit']") WebElement submitBtn;


	//confirmationMessage

	@FindBy(xpath="//body/script[1]") WebElement msgConfirmation;
	
	
	
	//Login button
	
	@FindBy(xpath="//a[@id='login-button']") WebElement LoginBtn;



	public void clickRegisterBtn()
	{
		registerBtn.click();
	}

	public void clickStudentBtn()
	{
		StudentBtn.click();
	}

	public void setName(String name)
	{
		nameInputfield.sendKeys(name);
	}


	public void setPhoneNum(String mobileNum)
	{
		phoneNum.sendKeys(mobileNum);	
	}


	public void setEmail(String mail)
	{
		myemail.sendKeys(mail);
	}


	public void setPassword(String pass)
	{
		pwd.sendKeys(pass);
	}


	public void setCountry(String countryName)
	{
		countryname.sendKeys(countryName);
	}

	public void setAddress(String myaddress)
	{
		address.sendKeys(myaddress);
	}

	public void clickSubmit()
	{
		submitBtn.click();
	}


	public String getConfirmationmsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void clickLogin()
	{
		LoginBtn.click();
	}
}
