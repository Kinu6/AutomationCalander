package createOrganisation;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sriMataji.ObjectUtilities.CreateOrganisationPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewOrganizationPage;
import sriMataji.ObjectUtilities.OrganisationInformationPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateOrganisationWithIndustryTC05Test extends BaseClass {
 
	@Test()//retryAnalyzer =sriMataji.genericUtilities.RetryAnalyzerImplementaion.class)
	public void tc05Test() throws EncryptedDocumentException, IOException, InterruptedException {
       
		String orgName= eUtil.readDataFromExcelFile("organizations", 4, 2)+jUtil.getRandomNumber();
		String indDD= eUtil.readDataFromExcelFile("organizations", 4, 3);
		
		HomePage hp= new  HomePage(BaseClass.getDriver());
		hp.getOrgTab().click();	    
		
		//Thread.sleep(20);
		
		CreateOrganisationPage cop= new CreateOrganisationPage(BaseClass.getDriver());
		wUtil.waitForElementToBeVisible(BaseClass.getDriver(), cop.getCreateOrgIcon());
		wUtil.waitForElementToBeClickable(BaseClass.getDriver(), cop.getCreateOrgIcon());
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage  ncp= new NewOrganizationPage(BaseClass.getDriver());
		ncp.createOrgWithIndustry(BaseClass.getDriver(), indDD, orgName);
		
		WebDriverWait w= new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
		
		w.until(ExpectedConditions.urlContains("viewname=0"));
		wUtil.waitForElementToBeClickable(BaseClass.getDriver(), ncp.getSaveBtn());
		
		//ncp.getSaveBtn().click();
		
		OrganisationInformationPage oip= new  OrganisationInformationPage(BaseClass.getDriver());
		
		Assert.assertTrue(oip.getHeaderTxt().getText().contains(orgName),"print");
	
	}
}
