package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.TestUtilities;
import pages.*;

public class GlueCode {
	public static WebDriver driver;
	static WebDriverWait wait;
	Scenario s;
	static Properties prop;
	static TestUtilities t;
	static UsernamePage up;
	static PasswordPage pp;
	static SearchPage sp;
	
	@Before
	public void setUp(Scenario s) throws IOException
	{
		this.s=s;
		prop=new Properties();
		FileInputStream f=new FileInputStream("src\\test\\resources\\common.properties");
		prop.load(f);
	}
	
	@Given("^I navigate to the login page using \"(.*)\"$")
	public void launchSite(String browser) throws Exception
	{
		t=new TestUtilities();
		driver = (WebDriver) t.assignBrowser(browser);
		driver.get(prop.getProperty("baseUrl"));
		if(!driver.getTitle().contains(prop.getProperty("siteTitle")))
		{
			String ssname=t.screenshot(driver);
			Assert.fail("Title mismatch goto "+ssname);
		}
		driver.manage().window().maximize();
		//assign page objects
		pp=new PasswordPage(driver);
		up=new UsernamePage(driver);
		sp=new SearchPage(driver);
		//end
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(up.signInLink));
		up.clickSignInLink();
		wait.until(ExpectedConditions.visibilityOf(up.username));
		
	}
	
	@Then("^enter username as \"(.*)\"$")
	public void enterUsername(String user)
	{
		up.fillUsername(user);
	}
	
	@And("^click continue$")
	public void clickContinue()
	{
		up.clickContinue();
	}
	
	
	@Then("^check with \"([^\"]*)\"$")
	public void checkConditions(String criteria) throws Exception 
	{		
		if(criteria.contains("invalid_mobile") && up.usernameInvalidMobile!=null){
			s.write("Invalid mobile number test passed");
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(screenshot, ".png");
		}
		else if(criteria.contains("empty") && up.usernameEmpty!=null)
			s.write("Empty username test passed");
		else if(criteria.contains("invalid_email") && up.usernameInvalidEmail!=null)
			s.write("Invalid email test passed");
		else if(criteria.contains("valid_email") && pp.password!=null)
			s.write("Valid email test passed");
		else if(criteria.contains("valid_mobile") && pp.password.isEnabled()) 
			s.write("Valid mobile number test passed");
		else{
			String ssname=t.screenshot(driver);
			Assert.fail("Username test failed!!...goto "+ssname);
		}			
	}
	
	@And("^close site$")
	public void closeSite()
	{
		t.close();
		driver=null;
		this.s=null;
	}
	
	@Then("^enter valid username$")
	public void entervalidUsername()
	{
		up.fillUsername(prop.getProperty("username"));
	}
	
	@Given("^verify password page is opened$")
	public void checkPasswordPage() throws Exception
	{
		try{
			wait.until(ExpectedConditions.visibilityOf(pp.password));
		}
		catch(Exception ex){
			String ssname=t.screenshot(driver);
			Assert.fail("Password page not opened!!...goto "+ssname);
		}		
	}
	
	@Then("^enter password as \"(.*)\"$")
	public void enterPassword(String pwd)
	{
		pp.fillPassword(pwd);
	}
	
	@And("^click signin$")
	public void clickSignin()
	{
		pp.clickSignInBtn();
	}
	
	@Then("^check with password \"(.*)\"$")
	public void checkPwdConditions(String criteria) throws Exception
	{
		if(criteria.contains("empty") && pp.passwordEmpty.isDisplayed())
			s.write("Password empty test passed");
		else if(criteria.contains("invalid") && pp.passwordInvalid.isDisplayed())
			s.write("invalid password test matched");
		else if(criteria.contains("valid")){
			wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
//			Actions a=new Actions(driver);
//			a.moveToElement(target)
			if(sp.settingsLink!=null)
				s.write("Valid Password test passed");
			else{
				String ssname=t.screenshot(driver);
				Assert.fail("Password test failed!!...goto "+ssname);
			}
		}
		else{
			String ssname=t.screenshot(driver);
			Assert.fail("Password test failed!!...goto "+ssname);
		}
	}
	
	@Then("^enter password$")
	public void enterValidPassword()
	{
		pp.fillPassword(prop.getProperty("password"));
	}
	
	public Object getDriver()
	{	return driver; 		}
	
	public Object getWait()
	{	return wait;		}
	
}
