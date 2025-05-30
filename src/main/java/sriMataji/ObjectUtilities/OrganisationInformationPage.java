package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
      
	@FindBy(xpath ="//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	private WebDriver driver;
	
	public  OrganisationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this); }
	
	public WebElement getHeaderTxt() {
		return HeaderTxt;
	}
}

