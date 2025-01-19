package practice12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test( dataProvider = "getData")
	public void addToCart(String phoneName, int price, String colour, boolean isAvaliable) {
	   
		/* The @DataProvider in TestNG is used to supply multiple sets of data to a single test method.
	     *  It enables data-driven testing, where the same test logic is executed with different inputs and expected outputs.
	     */
		System.out.println("Name "+phoneName+"price "+price+"colour "+colour+"IsAvaliable "+isAvaliable);	}
	
	@DataProvider
	public Object[][] getData(){
		                            //row //cell
		Object[][] oRef= new Object[2][4]; //two data sets having 4 details inside
		
		oRef[0][0]="Samsung";
		oRef[0][1]=1399;
		oRef[0][2]="Pink";
		oRef[0][3]=true;
		
		oRef[1][0]="Apple";
		oRef[1][1]=111399;
		oRef[1][2]="Orange";
		oRef[1][3]=false;
		
		return oRef;
	}
	
	
	
	
}
