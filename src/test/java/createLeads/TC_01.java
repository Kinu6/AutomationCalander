package createLeads;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import lombok.Data;
import sriMataji.ObjectUtilities.CreateLead;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.LeadInformation;
import sriMataji.ObjectUtilities.NewLeadsPage;
import sriMataji.genericUtilities.BaseClass;
import sriMataji.genericUtilities.ExcelFileUtility;

@Listeners(sriMataji.genericUtilities.ListenersImplementaion.class)
public class TC_01 extends BaseClass {

	@Test(groups = {"smokeSuite" })
	public void methodTC_01() throws EncryptedDocumentException, IOException {

		ExcelFileUtility eUtil = new ExcelFileUtility();

		String lastName = eUtil.readDataFromExcelFile("leads", 01, 01);

		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.getLeadsTab().click();

		CreateLead cl = new CreateLead(BaseClass.getDriver());
		wUtil.waitForElementToBeClickable(BaseClass.getDriver(), cl.getCreateLeadIcon());
		cl.getCreateLeadIcon().click();

		NewLeadsPage np = new NewLeadsPage(BaseClass.getDriver());
		np.addNewLeadsWithBasicInfo(BaseClass.getDriver());

		LeadInformation li = new LeadInformation(BaseClass.getDriver());

		assertTrue(new LeadInformation(BaseClass.getDriver()).getLeadInfoTxt().getText().contains(lastName), "HI");

	}

//	@Test()
//	public void methodTC_02() {
//
//		System.out.println("Hi"); /*
//									 * Why methodTC_02 Fails If methodTC_02 runs after methodTC_01, it starts a new
//									 * test execution. But methodAfterMethod() already logged out in methodTC_01, so
//									 * methodTC_02 is trying to execute without being logged in. Also, if
//									 * driver.quit(); from @AfterClass runs before methodTC_02, the driver is null,
//									 * and Selenium throws an exception.
//									 */
//	}
}
