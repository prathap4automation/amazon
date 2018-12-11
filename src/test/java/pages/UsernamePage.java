package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsernamePage {
	static WebDriver driver;
	
	//element locators
		@FindBy(xpath="(//span[text()='Your Orders'])[2]")
		public WebElement signInLink;
		
		@FindBy(name="email")
		public WebElement username;
		
		@FindBy(xpath="//input[@id='continue']")
		public WebElement loginContinue;
		
		@FindBy(xpath="//div[contains(text(),'Enter your email')]")
		public WebElement usernameEmpty;
		
		@FindBy(xpath="//span[contains(text(),'The phone number you entered')]")
		public WebElement usernameInvalidMobile;
		
		@FindBy(xpath="//span[contains(text(),'We cannot find an account')]")
		public WebElement usernameInvalidEmail;
		
		//constructor
		public UsernamePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//operational methods
		public void clickSignInLink()
		{	signInLink.click();			}
		
		public void fillUsername(String x)
		{	username.sendKeys(x); 		}
		
		public void clickContinue()
		{	loginContinue.click(); 		}
}
