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

public class CreateContactwithOrganisation_TC02Test extends BaseClass {

	@Test
	public void TC02() throws InterruptedException, EncryptedDocumentException, IOException {
		String lastName=eUtil.readDataFromExcelFile("contacts", 4, 3);
		String orgName=eUtil.readDataFromExcelFile("contacts", 4, 2);
	
	HomePage hp= new HomePage(driver);
	hp.getContactstab().click();
	
	//Thread.sleep(Duration.ofSeconds(10));
	
	CreateContactPage ccp= new CreateContactPage(driver);
	ccp.getCreateContactIcon().click();
	
	NewContactPage ncp= new NewContactPage(driver);
	ncp.addOrgName(lastName, orgName);
	
	ContactInformationPage cip=new ContactInformationPage(driver);
	if(cip.getHeaderTxt().getText().contains(lastName)) {
		System.out.println("Its "+ lastName);
	}
	
	if(cip.getHeaderTxt().getText().contains(orgName)) {
		System.out.println("Its "+orgName);
	}
	
	}
}
