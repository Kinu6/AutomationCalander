package createLeads;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import sriMataji.ObjectUtilities.CreateLead;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.LeadInformation;
import sriMataji.ObjectUtilities.NewLeadsPage;
import sriMataji.genericUtilities.BaseClass;
import sriMataji.genericUtilities.ExcelFileUtility;

public class TC_01  extends BaseClass {

	@Test
	public void methodTC_01() throws EncryptedDocumentException, IOException {
		
		 ExcelFileUtility eUtil= new ExcelFileUtility();
	     String company= eUtil.readDataFromExcelFile("leads", 01, 02);
		
		HomePage hp= new HomePage(driver);
		hp.getLeadsTab().click();
		
		CreateLead cl= new CreateLead(driver);
		cl.getCreateLeadIcon().click();
		
		NewLeadsPage np= new NewLeadsPage(driver);
		np.addNewLeadsWithBasicInfo(driver);
		
		assertEquals(new LeadInformation(driver).getLeadInfoTxt().getText().contains(company), true);
	}
	
	
}
