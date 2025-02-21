package practice12;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import sriMataji.genericUtilities.PropertyFileUtility;

public class p1{

	public static void main(String[] args) throws IOException {
		
		String key="webdriver.gecko.driver";
		String value="C:\\Users\\KESHRI\\Downloads\\Compressed\\geckodriver-v0.32.1-win64\\geckodriver.exe";
		
		System.setProperty(key, value);
		
		WebDriver driver= null;
		driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		try {
		    
			driver.get("http://localhost:8181/");
			
			//Login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//create contact
			driver.findElement(By.linkText("Contacts")).click();
			
			//Thread.sleep(Duration.ofSeconds(10));
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			driver.findElement(By.name("lastname")).sendKeys("Harshit");
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			
			WebElement e= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			Actions acton= new Actions(driver);
			acton.moveToElement(e).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			System.out.println("Logged out");
			
		}catch(Exception e) {
			
			System.out.println("Code :"+e);
		}finally {
			
			if(driver!=null) {
				System.out.println("Expelled");
			}
			
		}
		
		PropertyFileUtility pu= new PropertyFileUtility();
		String q= pu.readDataFromPropertyFile("url");
		System.out.println(q);	
		
	}

}
