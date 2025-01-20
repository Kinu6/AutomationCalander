package createContact;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;
import sriMataji.genericUtilities.ExcelFileUtility;

@Listeners(sriMataji.genericUtilities.ListenersImplementaion.class)

public class CreateContact_T01Test extends BaseClass {

	@Test(groups = "smokeSuite")
	public void tc01Test() throws EncryptedDocumentException, IOException, InterruptedException{
	    ExcelFileUtility eUtil= new ExcelFileUtility();
		String orgName= eUtil.readDataFromExcelFile("contacts", 01, 02);
		
		HomePage hp= new HomePage(driver);
	    hp.getContactstab().click();
	    
	    //Thread.sleep(Duration.ofSeconds(10));
	    
	    CreateContactPage cp= new CreateContactPage(driver);
	    wUtil.waitForElementToBeClickable(driver, cp.getCreateContactIcon());
	    wUtil.waitForElementToBeVisible(driver, cp.getCreateContactIcon());
	    cp.getCreateContactIcon().click();
	    
	    NewContactPage np= new NewContactPage(driver);
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
