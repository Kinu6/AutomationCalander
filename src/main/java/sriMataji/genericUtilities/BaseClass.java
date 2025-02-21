package sriMataji.genericUtilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import sriMataji.ObjectUtilities.HomePage;
import sriMataji.ObjectUtilities.LoginPage;



public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public	PropertyFileUtility pUtil= new PropertyFileUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	//public DatabaseUtility dUtil= new DatabaseUtility();
	public JavaUtility jUtil= new JavaUtility();
	
	

	@BeforeSuite(groups={"smokeSuite","regressionSUite"})
	public void methodBeforeSuite(){
		//Connect to DB
		//dUtil.executeQueryJDBC("insert into my_table values(4,'Hari',30);", "my_table");
		System.out.println("DataBase Connected");
	}
	
	//@Parameters("browser")
	//@BeforeTest //For parallel executions
	@BeforeClass(groups= {"smokeSuite","regressionSUite"})
	public void methodBeforeClass(/*String BROWSER*/) throws IOException {
	//Reading datas
		String URL= pUtil.readDataFromPropertyFile("url");
		String BROWSER= pUtil.readDataFromPropertyFile("browser");
		
		System.out.println(BROWSER);
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			FirefoxOptions options= new FirefoxOptions();
			options.setCapability("moz:webdriverClick", true);
		} else {
			System.out.println("Invalid Browser");
		}
		
		// Pass the WebDriver to the BaseClass constructor
		sDriver= driver; //For Listeners
		//System.out.println(";"+ sDriver);
	    wUtil.maximizeWindow(driver);
	    driver.get(URL);
	}
	    
	@BeforeMethod(groups={"smokeSuite","regressionSUite"})
	public void methodBeforeMethod() throws Throwable{
		//Login to app
	    String USERNAME= pUtil.readDataFromPropertyFile("username");
	    String PASSWORD= pUtil.readDataFromPropertyFile("password"); 
	    LoginPage lp= new LoginPage(driver);
	    lp.loginToApp(USERNAME, PASSWORD);
	    System.out.println("Login to app");
	}
	
	@AfterMethod(groups={"smokeSuite","regressionSUite"})
	public void methodAfterMethod(){
	    HomePage hp= new HomePage(driver);
	    hp.logOut(driver);
	} 
	//@AfterTest
	@AfterClass(groups={"smokeSuite","regressionSUite"})
	public void methodAfterClass(){
	    //close Browser
	    driver.close();
	}
	
	@AfterSuite(groups={"smokeSuite","regressionSUite"})
	public void methodAfterSuite() {
	    //Close DB 
	    System.out.println("DB Connection closed sucessfully");
	}
	
}
