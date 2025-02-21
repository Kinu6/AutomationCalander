package practice12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import sriMataji.ObjectUtilities.CreateContactPage;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.NewContactPage;
import sriMataji.genericUtilities.BaseClass;

public class CssPractice extends BaseClass{

	@Test 
	/*static void main(String[] args) {*/
	public void f() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.getContactstab().click();
		
		Thread.sleep(20);
		CreateContactPage cp= new  CreateContactPage(driver);
		cp.getCreateContactIcon().click();
		
		//NewContactPage np=new NewContactPage(driver);
		
		driver.findElement(By.cssSelector("#title")).sendKeys("INDIA");;
		
		//driver.findElement(By.cssSelector(font-family= 'Arial, Helvetica, sans-serif'));
		
		
		
	}
}
