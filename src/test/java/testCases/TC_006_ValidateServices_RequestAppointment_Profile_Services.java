package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ServicesPageInStudentDashboard;
import testBase.BaseClass;
@Listeners(utilities.ExtentReportManager.class)
public class TC_006_ValidateServices_RequestAppointment_Profile_Services extends BaseClass {
	
	
	@Test
	public void validateServicesRequestAppointmentInProfilePage()
	{
		//HomePage
				logger.info("***Starting TC_006_ServiceValidation TestCase***");
				
				
					logger.info("Home page is Launched!");
				HomePage hp = new HomePage(driver);
				logger.info("Clicked on Login Button!");
				hp.clickLogin();
				
				// Loginpage
				LoginPage lp = new LoginPage(driver);
				logger.info("Entered Email!");
				lp.setUsername(p.getProperty("email"));
				logger.info("Enter password!");
				lp.setPassword(p.getProperty("password"));
				 // Ensure the element is in view
				logger.info("Scrolled To click on LoginButton!");
		        lp.scrollToLoginBtn();

		        // Try regular click
		        try {
		        	logger.info("clicked on LoginButton!");
		            lp.clickLoginBtn();
		        } catch (Exception e) {
		           
		            lp.clickLoginBtnWithJS();
		        }
				
				
		        
		        
		        ServicesPageInStudentDashboard dashboard = new ServicesPageInStudentDashboard(driver);
		        logger.info("clicked on servicesLink!");
		        dashboard.clickServiceslink();
		        scrollTillBtn();
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        WebElement learnMoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Accommodation7032']//a[contains(text(), 'Learn More')]")));
		        learnMoreButton.click();
		        
		        dashboard.clickRequestAppointment();
		        
		        dashboard.setname(p.getProperty("name"));
		        
		        dashboard.setNum(p.getProperty("phonenum"));
		        dashboard.setMail(p.getProperty("email"));
		        dashboard.setMessage(p.getProperty("message"));
		        
		        dashboard.clickSubmit();
		        
		        dashboard.clickLogo();
		        dashboard.clickProfile();
		        dashboard.clickServices();
		        
		        
	}
}
		        
		        
		        
			



