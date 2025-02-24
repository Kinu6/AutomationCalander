package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
    //Create a POM class dear
	// Create Webelement using FindBy
	@FindBy(xpath  = "//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Contact...']") private WebElement CreateContactIcon;
	private WebDriver driver;
	//Constructor
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//getters
	public WebElement getCreateContactIcon() {
		return CreateContactIcon;
	}
}
