package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
     
	@FindBy(css="img[title='Create Organization...']") private WebElement CreateOrgIcon;                            
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgIcon() {
		return CreateOrgIcon;
	}
}
