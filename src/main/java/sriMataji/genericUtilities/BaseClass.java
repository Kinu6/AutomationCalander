package sriMataji.genericUtilities;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // ThreadLocal variables are specific
																					// to each thread,

	public static WebDriver getDriver() {// Actual WebDriver Instance ` // ThreadLocal<WebDriver> this returns entire
											// object which o dont need ,
		// i need to call .get Manually like earlier
		if (driver.get() == null) {
			throw new IllegalStateException("WebDriver is not initialized! Ensure @BeforeMethod is executed.");
		}
		return driver.get();
	}

	public static void setDriver(WebDriver webDriver) { // The issue likely arises because your driver variable is
														// private inside BaseClass, and your second test method in the
														// same class cannot directly access it.
		// BaseClass.driver = driver;
		driver.set(webDriver);
	}

	/*
	 * If it wasn’t static, every new instance of BaseClass would create a new
	 * ThreadLocal<WebDriver>, which is unnecessary. We need only one ThreadLocal
	 * storage per test suite, not per test class instance. static ensures that the
	 * ThreadLocal variable is shared across all instances of BaseClass, while still
	 * keeping separate WebDriver instances per thread.
	 */

	// public static WebDriver sDriver;
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	// public DatabaseUtility dUtil= new DatabaseUtility();
	public JavaUtility jUtil = new JavaUtility();

	@BeforeSuite(groups = { "smokeSuite", "regressionSUite" })
	public void beforeSuite() {
		// Connect to DB
		// dUtil.executeQueryJDBC("insert into my_table values(4,'Hari',30);",
		// "my_table");
		System.out.println("DataBase Connected");
	}

//	//@Parameters("browser")
//	//@BeforeTest //For parallel executions
//	@BeforeClass(groups= {"smokeSuite","regressionSUite"})
//	public void beforeClass(/*String BROWSER*/) throws IOException {
//	//Reading datas
//		String URL= pUtil.readDataFromPropertyFile("url");
//		String BROWSER= pUtil.readDataFromPropertyFile("browser");
//		
//		System.out.println(BROWSER);
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver= new ChromeDriver();
//		}else if(BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver= new FirefoxDriver();
//			FirefoxOptions options= new FirefoxOptions();
//			options.setCapability("moz:webdriverClick", true);
//		} else {
//			System.out.println("Invalid Browser");
//		}
//		
//		// Pass the WebDriver to the BaseClass constructor
//		sDriver= driver; //For Listeners
//		//System.out.println(";"+ sDriver);
//	    wUtil.maximizeWindow(driver);
//	    driver.get(URL);
//	} 

	// @BeforeTest //For Parallel Exceutions
	// @Parameters("BROWSER")
	//@BeforeClass
	 @BeforeMethod(groups={"smokeSuite","regressionSUite"})

	public void beforeMethod(/* String BROWSER */) throws Throwable {

		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = System.getProperty("browser"); ////pUtil.readDataFromPropertyFile("browser");

		System.out.println(BROWSER);
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
			// setDriver(new ChromeDriver()); should accept a WebDriver instance, not
			// ThreadLocal<WebDriver>.
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			//setDriver(new FirefoxDriver());
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("moz:webdriverClick", true);
			setDriver(new FirefoxDriver(options));
		} 
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
			// setDriver(new ChromeDriver()); should accept a WebDriver instance, not
			// ThreadLocal<WebDriver>.
		}
			else {
			System.out.println("Invalid Browser");
		}

		// Pass the WebDriver to the BaseClass constructor
		// sDriver = driver.get(); // For Listeners
		// System.out.println(";"+ sDriver);
		wUtil.maximizeWindow(getDriver());
		getDriver().get(URL);

		// Login to app
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(getDriver());
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to app");
	}

	//@AfterClass
	// @AfterTest
	 @AfterMethod(groups = { "smokeSuite", "regressionSUite" })
	public void afterMethod() {

		try {
			if (getDriver() != null) {
				HomePage hp = new HomePage(getDriver());
				hp.logOut(getDriver());
			}
		} catch (Exception e) {
			System.out.println("LogOut Failed");
		}
		getDriver().quit();
		driver.remove();
		// driver=null;
		/*
		 * You're setting driver = null; instead of clearing ThreadLocal<WebDriver>
		 * properly
		 * 
		 * driver is a ThreadLocal<WebDriver>, so setting driver = null; does not remove
		 * the WebDriver instance from the thread. Instead, you should call
		 * driver.remove(); to clear the WebDriver from ThreadLocal.
		 * 
		 * getDriver().quit(); is called even if driver.get() is already null
		 * 
		 * If driver.get() is null, calling getDriver().quit(); will throw a
		 * NullPointerException. You need to check if getDriver() is null before calling
		 * quit().
		 */
	}

//	// @AfterTest
//	@AfterClass(groups = { "smokeSuite", "regressionSUite" })
//	public void afterClass() {
//		// close Browser
//		driver.quit();// Close will fail another test script as If both tests need a fresh login,
//						// ensure that login runs before each test.
//		driver = null; // For If running parallel tests or reusing driver across multiple test cases:
//						
//	}

	@AfterSuite(groups = { "smokeSuite", "regressionSUite" })
	public void methodAfterSuite() {
		// Close DB
		System.out.println("DB Connection closed sucessfully");
	}

}
