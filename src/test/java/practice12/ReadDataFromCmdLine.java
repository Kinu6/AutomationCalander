package practice12;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	
	public void methodTC01() {
		
		String browser= System.getProperty("browser");
		System.out.println(browser);
		String envD=System.getProperty("UATEnv");
		System.out.println(envD);
		String gi=System.getProperty("gi");
		System.out.println(gi);
		
	}

}
