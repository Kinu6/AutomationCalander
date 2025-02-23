package sriMataji.ObjectUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLead {
		//@FindBy(css = "img[title='Create Lead...'],[src='themes/softed/images/btnL3Add.gif']") private WebElement createLeadIcon;
	   //	css = "img[src='themes/softed/images/btnL3Add.gif'][title='Create Contact...']"
       
	    @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif' and @title='Create Lead...']") private WebElement createLeadIcon;
		private WebDriver driver;
	  //img[@src='themes/softed/images/btnL3Add.gif' and @title='Create Lead...']

        public CreateLead(WebDriver driver) {
        	this.driver=driver;
        	PageFactory.initElements(driver, this);
        }
		
		public WebElement getCreateLeadIcon() {
			return createLeadIcon;
		}

		

}
