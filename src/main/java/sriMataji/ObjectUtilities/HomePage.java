package sriMataji.ObjectUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriMataji.genericUtilities.WebDriverUtility;


public class HomePage extends WebDriverUtility{
// create a POM class for every  page dear
	// create a Find statement
	
	@FindBy(linkText = "Organizations") private WebElement OrgTab;
	@FindBy(linkText = "Contacts") private WebElement ContactsTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG' and @style='padding: 0px;padding-left:5px']") private WebElement adminIcon;
	@FindBy(xpath="//td[contains(@style,'padding-left:0px')]//a[text()='Sign Out']") private WebElement SignOutIcon;
	@FindBy(linkText = "Leads") private WebElement leadsTab;
	@FindBy(linkText = "Opportunities") private WebElement oppurtunities;
	private WebDriver driver=null;
	
	// Create a constructor
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	// Create Getters 
	public WebElement getOrgTab() {
		return OrgTab;
	}
	public WebElement getContactstab() {
		return ContactsTab;
	}
	public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getSignOutIcon() {
		return SignOutIcon;
	}
	public WebElement getLeadsTab() {
		return leadsTab;
	}

	public WebElement getOppurtunities() {
		return oppurtunities;
	}
	public void logOut(WebDriver driver) {
		
		//new WebDriverUtility().waitForElementToBeVisible(driver,SignOutIcon);
		
		mouseHoverAction(driver, adminIcon);
		/*
		 * //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignOutIcon);
		 
        
		// Execute JavaScript to click the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Remove obstructing element
		
		WebElement element = driver.findElement(By.xpath("//div[@id='__vtigerjs_dialogbox_olayer__' and @class['small veil']"));
        WebElement element1= driver.findElement(By.xpath("//input[@class='crmbutton small save'] and @name='button']"));
		// Remove the element using JavaScript
		
		js.executeScript("arguments[0].remove();", element);
		js.executeScript("arguments[0].remove();", element1);

		js.executeScript("arguments[0].scrollIntoView(true);", SignOutIcon); //scroll this into view
		
		js.executeScript("arguments[0].click();", SignOutIcon); //For handling org.openqa.selenium.ElementClickInterceptedException
		*/
		//SignOutIcon.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SignOutIcon);

	}
	
	
	
}
