package practice12;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.ContactInformationPage;
import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;
import sriMataji.genericUtilities.ExcelFileUtility;

public class UltraProMax extends BaseClass {
@Test
public void getInto() throws EncryptedDocumentException, IOException, InterruptedException{
	 ExcelFileUtility eUtil= new ExcelFileUtility();
		String orgName= eUtil.readDataFromExcelFile("contacts", 01, 02);
			
		HomePage hp= new HomePage(BaseClass.getDriver());
	    hp.getContactstab().click();
	   // Thread.sleep(Duration.ofSeconds(10));
	    
	    CreateContactPage cp= new CreateContactPage(BaseClass.getDriver());
	    wUtil.waitForElementToBeClickable(BaseClass.getDriver(), cp.getCreateContactIcon());
	    wUtil.waitForElementToBeVisible(BaseClass.getDriver(), cp.getCreateContactIcon());
	    cp.getCreateContactIcon().click();
	    
	    NewContactPage np= new NewContactPage(BaseClass.getDriver());
	    np.getLastName().sendKeys(orgName);
	    np.getSaveBtn().click();
	    
	    //Validations
	    ContactInformationPage cip= new ContactInformationPage(BaseClass.getDriver());
	    Assert.assertEquals(cip.getHeaderTxt().getText().contains(orgName), true);     
}
}
