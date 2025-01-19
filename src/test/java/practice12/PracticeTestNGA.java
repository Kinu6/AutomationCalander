package practice12;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestNGA {

	@BeforeSuite
	public void A() {
		System.out.println("A");
	}
	@BeforeTest
	public void B() {
		System.out.println("B");
	}
	@BeforeClass
	public void C() {
		System.out.println("C");
	}
	@BeforeMethod
	public void D() {
		System.out.println("D");
	}
	@Test
	public void E() {
		System.out.println("E");
	}
	@AfterMethod
	public void F() {
		System.out.println("F");
	}
	@AfterClass
	public void G() {
		System.out.println("G");
	}
	@AfterTest
	public void H() {
		System.out.println("H");
	}
	@AfterSuite
	public void I() {
		System.out.println("I");
	}	
	
}
