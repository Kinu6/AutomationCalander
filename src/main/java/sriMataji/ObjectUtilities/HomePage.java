package sriMataji.ObjectUtilities;

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
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement adminIcon;
	@FindBy(linkText = "Sign Out") private WebElement SignOutIcon;
	
	// Create a constructor
	public HomePage(WebDriver driver) {
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

	public void logOut(WebDriver driver) {
		mouseHoverAction(driver, adminIcon);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignOutIcon);
		SignOutIcon.click();
	}
	
	
	
}
