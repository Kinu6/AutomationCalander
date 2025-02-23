package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
    //Create a POM class dear
	// Create Webelement using FindBy
	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif'],[title='Create Contact...']") private WebElement CreateContactIcon;
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
