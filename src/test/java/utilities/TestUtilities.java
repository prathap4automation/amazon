package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import cucumber.api.Scenario;

public class TestUtilities {
	static Properties prop;
	Scenario s;
	static WebDriver driver;
	
	public void deleteAllCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
	
	public void driverCheck()
	{
		if(driver!=null){
			System.out.println("Driver already initiated");
			System.exit(0);
		}
	}
	
	public void loadProperties(Scenario s) throws Exception
	{
//		this.driverCheck();
		driver=null;
		this.s=s;
		prop=new Properties();
		FileInputStream f= new FileInputStream("src\\test\\resources\\common.properties");
		prop.load(f);
	}
	
	public Object assignChromeDriver() throws Exception
	{
		this.loadProperties(null);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
		driver=new ChromeDriver();
		return driver;
	}
	
	public Object assignFirefoxDriver() throws Exception
	{
		this.loadProperties(null);
		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverPath"));
		driver = new FirefoxDriver();
		return driver;
	}
	
	public Object assignOperaDriver() throws Exception
	{
		this.loadProperties(null);
		OperaOptions oo =new OperaOptions();
		oo.setBinary(prop.getProperty("operaBinaryPath"));
		System.setProperty("webdriver.opera.driver", prop.getProperty("operaDriverPath"));
		driver = new OperaDriver(oo);
		return driver;
	}
	
	public Object assignIeDriver() throws Exception
	{
		this.loadProperties(null);
		System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriverPath"));
		driver= new InternetExplorerDriver();
		return driver;
	}
	
	public void close()
	{
		driver.close();
		driver=null;
	}
	
	public void quit()
	{
		driver.quit();
		driver=null;
	}
	
	public String screenshot(WebDriver driver) throws Exception
	{
		Date dt=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-HH-mm-ss");
		String ssname=sf.format(dt)+".png";
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("screenshots\\"+ssname));
		return ssname;
	}
	
	public Object assignBrowser(String browser) throws Exception
	{
		switch(browser)
		{
		case "chrome":
			driver=(WebDriver)this.assignChromeDriver();break;
		case "firefox":
			driver=(WebDriver)this.assignFirefoxDriver();break;
		case "ie":
			driver = (WebDriver)this.assignIeDriver();break;
		case "opera":
			driver=(WebDriver)this.assignOperaDriver();break;
		default:
			Assert.fail("Invalid browser");System.exit(0);
		}
		
		return driver;
	}
}
