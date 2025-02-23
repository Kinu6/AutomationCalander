package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriMataji.genericUtilities.BaseClass;

public class LeadInformation {
	@FindBy(xpath="//span[contains(. ,'Lead')]") private WebElement leadInfoTxt;
	
	private WebDriver driver;
    public  LeadInformation(WebDriver driver) {
    	this.driver=driver;
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
    
	public WebElement getLeadInfoTxt() {
		return leadInfoTxt;
	}
}
