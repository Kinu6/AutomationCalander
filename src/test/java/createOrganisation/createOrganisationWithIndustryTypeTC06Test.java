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

public class createOrganisationWithIndustryTypeTC06Test extends BaseClass {

	@Test
	public void tc06() throws EncryptedDocumentException, IOException, InterruptedException {
       
		String orgName= eUtil.readDataFromExcelFile("organizations", 01, 02)+jUtil.getRandomNumber();
        String indDD= eUtil.readDataFromExcelFile("organizations", 4, 3);
        String typeDD= eUtil.readDataFromExcelFile("organizations", 4, 4);
		
        HomePage hp= new  HomePage(driver);
		hp.getOrgTab().click();
		System.out.println("Clicked on Org Tab");
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage  ncp= new NewOrganizationPage(driver);
		ncp.createOrgWithIndustry_type(orgName, indDD, typeDD);
		ncp.getSaveBtn().click();
		
		OrganisationInformationPage oip= new  OrganisationInformationPage(driver);
		wUtil.waitForElementToBeVisible(driver, oip.getHeaderTxt());
		if(oip.getHeaderTxt().getText().contains(orgName)){
			System.out.println("Its Passed"+ orgName);
		}
	}
}
