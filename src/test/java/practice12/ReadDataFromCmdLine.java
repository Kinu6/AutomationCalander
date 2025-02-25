package practice12;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	
	public void methodTC01() {
		
		String Browser= System.getProperty("browser");
		System.out.println(Browser);
		String envD=System.getProperty("UATEnv");
		System.out.println(envD);
		String gi=System.getProperty("gi");
		System.out.println(gi);
		
	}

}
