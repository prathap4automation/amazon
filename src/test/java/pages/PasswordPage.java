package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	static WebDriver driver;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement signInBtn;
	
	@FindBy(xpath="//div[contains(text(),'Enter your password')]")
	public WebElement passwordEmpty;
	
	@FindBy(xpath="//span[contains(text(),'password is incorrect')]")
	public WebElement passwordInvalid;
	
	//constructor
	public PasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void fillPassword(String x)
	{	password.sendKeys(x); 		}
	
	public void clickSignInBtn()
	{	signInBtn.click(); 			}
	
}
