package sriMataji.ObjectUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sriMataji.genericUtilities.BaseClass;

public class NewLeadsPage extends BaseClass{

	@FindBy(css= "input[name='lastname]") private WebElement lastname;
	@FindBy(css= "input[name='company']") private WebElement company;
	@FindBy(css ="input[title='Save [Alt+S]'") private WebElement saveBtn;
	@FindBy(css="select[name='leadsource']") private WebElement leadSourceDD;
	
    public NewLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLeadSourceDD() {
		return leadSourceDD;
	}
	
	public void addNewLeadsWithBasicInfo(WebDriver driver) {
		try {
			String lastName= eUtil.readDataFromExcelFile("leads", 1, 1);
			String company= eUtil.readDataFromExcelFile("leads", 1, 2);
			String leadSource=eUtil.readDataFromExcelFile("leads", 1, 3);
			
			getLastname().sendKeys(lastName);
			getCompany().sendKeys(company);
			
			wUtil.handleDropdown(leadSource, leadSourceDD);
			
			getSaveBtn().click();
			
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		
	}
	
	
}
