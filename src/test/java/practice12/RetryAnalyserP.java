package practice12;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RetryAnalyserP  {
	
	@Test(retryAnalyzer = sriMataji.genericUtilities.RetryAnalyzerImplementaion.class)
	public void readfi() {
		Assert.fail();
		System.out.println(("++++++++++++++++++++++++++"));
	}
}
