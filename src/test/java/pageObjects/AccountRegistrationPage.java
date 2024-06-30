package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
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

		@FindBy(xpath= "//script[normalize-space()='You successfully registered please login']") WebElement msgConfirmation;

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
	
	
}
