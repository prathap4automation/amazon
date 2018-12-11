package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	//locators
	@FindBy(xpath="//span[contains(text(),'Deliver to')]")
	public WebElement loginSuccess;
	
	@FindBy(xpath="//span[contains(text(),'Hello,')]")
	public WebElement settingsLink;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	public WebElement signOut;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(xpath="//div[contains(@class,'nav-search-submit')]/input")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='atfResults']/descendant::div[6]/a/img")
	public WebElement firstProduct;
	
//	@FindBy(xpath="//div[@id='rightCol']/child::div[3]/descendant::form[2]/descendant::div[2]/child::div[22]/descendant::span[2]/input")
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//*[text()='Add to your order']")
	public WebElement addToOrder;
	
	@FindBy(xpath="(//button[contains(text(),'Skip')])[3]")
	public WebElement skipAddToOrder;
	
	@FindBy(xpath="//a[@id='nav-cart']/span[4]")
	public WebElement cartNumber;
	
	//constructor
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//operational methods
	public void clear(WebElement e)
	{	e.clear(); 					}
	
	public void clickSignOut()
	{	signOut.click(); 			}
	
	public void fillSearchBox(String x)
	{	searchBox.sendKeys(x); 		}
	
	public void clickSearch()
	{	searchButton.click(); 		}
	
	public void clickOnFirstProduct()
	{	firstProduct.click(); 		}
	
	public void clickAddToCartBtn()
	{	addToCartBtn.click(); 		}
	
	public void clickSkipAddToOrder()
	{	skipAddToOrder.click(); 	}
	
	public int getCartValue()
	{	
		int total_items_in_cart=Integer.parseInt(cartNumber.getText());
		return total_items_in_cart;
	}
	
}
