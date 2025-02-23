package createContact;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateContactWithLeadSource_TC03Test extends BaseClass {
    
	@Test(groups="regressionSUite")
	public void methodTC03() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastName=eUtil.readDataFromExcelFile("contacts", 7, 2);
		String leadName=eUtil.readDataFromExcelFile("contacts", 7, 3);
	
	sriMataji.ObjectUtilities.HomePage hp= new sriMataji.ObjectUtilities.HomePage(BaseClass.getDriver());
	hp.getContactstab().click();
	
	//Thread.sleep(Duration.ofSeconds(10));
	wUtil.implicitWaits(BaseClass.getDriver());
	
	CreateContactPage ccp= new CreateContactPage(BaseClass.getDriver());
	ccp.getCreateContactIcon().click();
	
	NewContactPage ncp= new NewContactPage(BaseClass.getDriver());
	ncp.addLastnamewithLeadSource(lastName, leadName);
	
	ContactInformationPage cip=new ContactInformationPage(BaseClass.getDriver());
	Assert.assertEquals(cip.getHeaderTxt().getText().contains(lastName),true) ;
	

	}
}
