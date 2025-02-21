package createContact;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;
import sriMataji.genericUtilities.ExcelFileUtility;

@Listeners()

public class CreateContact_T01Test extends BaseClass {

	@Test(priority = 1, invocationCount = 2, alwaysRun = true)
	public void tc01Test() throws EncryptedDocumentException, IOException, InterruptedException{
		
	    ExcelFileUtility eUtil= new ExcelFileUtility();
		String orgName= eUtil.readDataFromExcelFile("contacts", 01, 02);
		
		sriMataji.ObjectUtilities.HomePage hp= new sriMataji.ObjectUtilities.HomePage(driver);
		wUtil.waitForElementToBeVisible(driver, hp.getContactstab());
		wUtil.waitForElementToBeClickable(driver, hp.getContactstab());
	    hp.getContactstab().click();
	    
	    CreateContactPage cp= new CreateContactPage(driver);
	    wUtil.waitForElementToBeVisible(driver, cp.getCreateContactIcon());
	    wUtil.waitForElementToBeClickable(driver, cp.getCreateContactIcon());
	    cp.getCreateContactIcon().click();
	    
	    NewContactPage np= new NewContactPage(driver);
	    wUtil.waitForElementToBeVisible(driver, np.getLastName());
	    wUtil.waitForElementToBeClickable(driver, np.getLastName());
	    np.getLastName().sendKeys(orgName);
	    np.getSaveBtn().click();
	    
	    //Validations
	    ContactInformationPage cip= new ContactInformationPage(driver);
	    Assert.assertEquals(cip.getHeaderTxt().getText().contains(orgName), true);
	}	
	
	@Test
	public void demo() {
		System.out.println("Its demo");
	}
	
}
