package sriMataji.ObjectUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //identify the webElements
	/*
	 * In Java coding standards, constants are typically written in all uppercase letters,
	 * separated by underscores, whereas variable names and objects (including WebElements) are written in camelCase.
	 * 
	 * 
	 * Encapsulation means only showing important things and important things i.e working is hidden. So that no one mess with this
	 */
	
	@FindBy(name=("user_name")) private WebElement username_edt;
	@FindBy(name=("user_password")) private WebElement password_edt;
    @FindBy(id= ("submitButton")) private WebElement button;
    
    //Create a constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	//Use this
	public WebElement getUSERNAME_EDT() {
		
		return username_edt;
	}
    public WebElement getPASSWORD_EDT() {
		
		return password_edt;
	}
    public WebElement getBUTTON() {
	
	    return button;
    }
	
    //driver: The WebDriver instance, allowing interaction with the browser.
    //this: Refers to the current instance of the LoginPage class. It tells PageFactory to initialize the elements defined in this class.

	
    /**
	 * This Method will help Logging In 
	 * @param username
	 * @param password
	 */
	// Business Libraries- Generic Methods specific to current Project
	public void loginToApp(String username, String password) {
		username_edt.sendKeys(username);
		password_edt.sendKeys(password);
		button.click();
	}	
	
	
	
	
	
	
	
	
}
