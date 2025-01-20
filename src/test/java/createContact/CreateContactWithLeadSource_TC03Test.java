package createContact;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateContactWithLeadSource_TC03Test extends BaseClass {
    
	@Test(groups="regressionSUite")
	public void methodTC03() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastName=eUtil.readDataFromExcelFile("contacts", 7, 2);
		String leadName=eUtil.readDataFromExcelFile("contacts", 7, 3);
	
	HomePage hp= new HomePage(driver);
	hp.getContactstab().click();
	
	//Thread.sleep(Duration.ofSeconds(10));
	
	CreateContactPage ccp= new CreateContactPage(driver);
	ccp.getCreateContactIcon().click();
	
	NewContactPage ncp= new NewContactPage(driver);
	ncp.addLastnamewithLeadSource(lastName, leadName);
	
	ContactInformationPage cip=new ContactInformationPage(driver);
	if(cip.getHeaderTxt().getText().contains(lastName)) {
		System.out.println("Its "+ lastName);
	}
	
	if(cip.getHeaderTxt().getText().contains(leadName)) {
		System.out.println("Its "+leadName);
	}
	
	}
}
