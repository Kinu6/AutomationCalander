package createOrganisation;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.CreateOrganisationPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewOrganizationPage;
import sriMataji.ObjectUtilities.OrganisationInformationPage;
import sriMataji.genericUtilities.BaseClass;

public class createOrganisationWithIndustryTypeTC06Test extends BaseClass {	

	@Test
	public void tc06() throws EncryptedDocumentException, IOException, InterruptedException {
       
		String orgName= eUtil.readDataFromExcelFile("organizations", 7, 02)+jUtil.getRandomNumber();
        String indDD= eUtil.readDataFromExcelFile("organizations", 7, 3);
        String typeDD= eUtil.readDataFromExcelFile("organizations", 7, 4);
		
        HomePage hp= new  HomePage(driver);
        hp.getOrgTab().click();
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
	    Thread.sleep(Duration.ofSeconds(10));
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage  ncp= new NewOrganizationPage(driver);
		ncp.createOrgWithIndustry_type(orgName, indDD, typeDD);
		ncp.getSaveBtn().click();
		
		OrganisationInformationPage oip= new  OrganisationInformationPage(driver);
		wUtil.waitForElementToBeVisible(driver, oip.getHeaderTxt());
		System.out.println(hashCode());
		
		Assert.assertEquals(oip.getHeaderTxt().getText().contains(orgName), true);
		
		/*
		 wUtil.waitForInvisibility(driver,"__vtigerjs_dialogbox_olayer__");
		
		 WebElement saveButton = driver.findElement(By.className("crmbutton small save"));
		 saveButton.click();
		
		WebElement closeButton = driver.findElement(By.xpath("//input[@class='__vtigerjs_dialogbox_olayer__' and @name='button']")); // Replace with actual ID
		   closeButton.click();

		   WebElement saveButton = driver.findElement(By.className("crmbutton small save"));
		   saveButton.click();  */
	}
}
