package createOrganisation;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.CreateOrganisationPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewOrganizationPage;
import sriMataji.ObjectUtilities.OrganisationInformationPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateOrganisationWithIndustryTC05Test extends BaseClass {
 
	@Test
	public void tc05Test() throws EncryptedDocumentException, IOException, InterruptedException {
        String orgName= eUtil.readDataFromExcelFile("organizations", 04, 02)+jUtil.getRandomNumber();
		String indDD= eUtil.readDataFromExcelFile("organizations", 4, 3);
		
		HomePage hp= new  HomePage(driver);
		hp.getOrgTab().click();
		System.out.println("Clicked on Org Tab");
	
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		wUtil.waitForElementToBeVisible(driver, cop.getCreateOrgIcon());
		wUtil.waitForElementToBeClickable(driver, cop.getCreateOrgIcon());
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage  ncp= new NewOrganizationPage(driver);
		ncp.createOrgWithIndustry(indDD, orgName);
		ncp.getSaveBtn().click();
		
		OrganisationInformationPage oip= new  OrganisationInformationPage(driver);
		if(oip.getHeaderTxt().getText().contains(orgName)){
			System.out.println("Its Passed"+ orgName);
		}
	
	}
}
