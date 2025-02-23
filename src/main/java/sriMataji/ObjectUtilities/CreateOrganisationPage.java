package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriMataji.genericUtilities.BaseClass;

public class CreateOrganisationPage {
     
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement CreateOrgIcon;
	private WebDriver driver;
	
	public CreateOrganisationPage(WebDriver driver) {
		this.driver=BaseClass.getDriver();
		
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgIcon() {
		return CreateOrgIcon;
	}
}
