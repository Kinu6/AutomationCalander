package sriMataji.ObjectUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sriMataji.genericUtilities.BaseClass;

public class NewOrganizationPage extends BaseClass{
    @FindBy(name="accountname") private WebElement OrgNameEdt;
    @FindBy (name="industry") private WebElement IndustryDD;
    @FindBy(name="accounttype") private WebElement TypeDD;
    @FindBy(xpath="(//div[@align='center']//input[contains(@class,'save')])[1]") private WebElement SaveBtn;
    
    private  WebDriver driver;
   
   //  public NewOrganizationPage(WebDriver BaseClass.getDriver()) {// This is an identifier Now
    public NewOrganizationPage(WebDriver driver) {	
        this.driver=BaseClass.getDriver();
    	PageFactory.initElements(BaseClass.getDriver(), this);
    }
    
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	/**
	 * This Mehod will create OrgName with Industry
	 * @param INDUSTRY
	 * @param ORGNAME
	 */
	public void createOrgWithIndustry(WebDriver driver, String VALUE, String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		wUtil.handleDropdown(IndustryDD, VALUE);
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
	    
	    wUtil.waitForElementToBeVisible(driver, SaveBtn);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SaveBtn);*/

		SaveBtn.click();
	}
	/**
	 * This Method will create OrgName with Industry and TypeDD
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param Type
	 */
	public void createOrgWithIndustry_type(WebDriver
			 driver, String ORGNAME, String INDUSTRY, String Type) {
		OrgNameEdt.sendKeys(ORGNAME);
		wUtil.handleDropdown(INDUSTRY, IndustryDD);
		wUtil.handleDropdown(Type, TypeDD);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", SaveBtn); */
		SaveBtn.click();
	}
	
}
