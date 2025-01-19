package createOrganisation;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import sriMataji.ObjectUtilities.CreateOrganisationPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewOrganizationPage;
import sriMataji.ObjectUtilities.OrganisationInformationPage;
import sriMataji.genericUtilities.BaseClass;

public class CreateOrganisationTC04Test extends BaseClass{
	
	@Test
	public void tc04Test() throws InterruptedException, EncryptedDocumentException, IOException {
		
		String orgName= eUtil.readDataFromExcelFile("organizations", 01, 02)+jUtil.getRandomNumber();
		
		HomePage hp= new  HomePage(driver);
		hp.getOrgTab().click();
		
		Thread.sleep(Duration.ofSeconds(5));
	
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage  ncp= new NewOrganizationPage(driver);
		ncp.getOrgNameEdt().sendKeys(orgName);
		ncp.getSaveBtn().click();
		
		OrganisationInformationPage oip= new  OrganisationInformationPage(driver);
		wUtil.waitForElementToBeVisible(driver, oip.getHeaderTxt());
		Assert.assertEquals(oip.getHeaderTxt().getText().contains(orgName),true,"yoyo");
		
		/*
		 * 1. ElementNotInteractableException
This occurs while trying to click on the "Sign Out" button (//a[.='Sign Out']). The error message states the element cannot be scrolled into view, meaning it might 
not be visible or accessible at the time of interaction.

Possible Causes:

The element is not displayed on the page at the time of interaction.
The element is overlapped by another UI component.
The browser's viewport does not currently display the element.
Solution:

Use Actions class or JavaScript Executor to ensure the element is scrolled into view before interacting with it:

		2- The test is unable to locate the element with the XPath //span[@class='dvHeaderText']. This could mean:

The page did not load completely before the search.
The element is not present in the DOM, possibly due to incorrect navigation or missing data.
The XPath provided is incorrect or doesn't match the element.
Solution:

Verify the XPath in your browser's DevTools to ensure it matches the target element.
Add an explicit wait for the element to be visible before interacting with it:
java
Copy code
 */

	}

}
