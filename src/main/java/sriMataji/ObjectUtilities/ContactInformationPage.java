package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriMataji.genericUtilities.BaseClass;

public class ContactInformationPage {
    // Create POM Class
	// Create FindBy
	 @FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	private WebDriver driver;
	// Create Constructor
	 public ContactInformationPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(BaseClass.getDriver(), this);
	 }
	 public WebElement getHeaderTxt() {
		 return HeaderTxt;
		 
		 
	 }
}
