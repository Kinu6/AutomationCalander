package createContact;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateContactwithOrganisation_TC02Test extends BaseClass {

	@Test()
	public void TC02() throws InterruptedException, EncryptedDocumentException, IOException {
		String lastName=eUtil.readDataFromExcelFile("contacts", 4, 3);
		String orgName=eUtil.readDataFromExcelFile("contacts", 4, 2)+jUtil.getRandomNumber();
		System.out.println(lastName+orgName);
	
	sriMataji.ObjectUtilities.HomePage hp= new sriMataji.ObjectUtilities.HomePage(BaseClass.getDriver());
	//Now First Create an Organisations with Name taken during Compilation i.e from Excel Sheet with variable orgName
		{
			hp.getOrgTab().click();	
			
			sriMataji.ObjectUtilities.CreateOrganisationPage cop= new sriMataji.ObjectUtilities.CreateOrganisationPage(BaseClass.getDriver());
		    wUtil.waitForElementToBeClickable(BaseClass.getDriver(), cop.getCreateOrgIcon());
			cop.getCreateOrgIcon().click();
			
			sriMataji.ObjectUtilities.NewOrganizationPage  nop= new sriMataji.ObjectUtilities.NewOrganizationPage(BaseClass.getDriver());
			WebElement e= nop.getOrgNameEdt(); // is not reachable by keyboard
			
			//JavascriptExecutor jsR= (JavascriptExecutor) BaseClass.getDriver();
			//jsR.executeScript("arguments[0].value='"+ orgName +"';", e);
			
			e.click();   //Otherway
			e.sendKeys(orgName);	
			nop.getSaveBtn().click();
			
			sriMataji.ObjectUtilities.OrganisationInformationPage oip= new  sriMataji.ObjectUtilities.OrganisationInformationPage(BaseClass.getDriver());
			wUtil.waitForElementToBeVisible(BaseClass.getDriver(), oip.getHeaderTxt());
			
			//Assert.assertEquals(oip.getHeaderTxt().getText().contains(orgName),true,"OrgName Created");
		}
		
	hp.getContactstab().click();
	
	CreateContactPage ccp= new CreateContactPage(BaseClass.getDriver());
	ccp.getCreateContactIcon().click();
	
	NewContactPage ncp= new NewContactPage(BaseClass.getDriver());
	ncp.getLastName().sendKeys(lastName);
	ncp.addOrgName(lastName, orgName);
	
	ContactInformationPage cip=new ContactInformationPage(BaseClass.getDriver());
	Assert.assertTrue(cip.getHeaderTxt().getText().contains(lastName));
	}
}
