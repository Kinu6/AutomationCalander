package practice12;

import org.testng.annotations.Test;

public class TestNgPractice1 {
	
    @Test(priority = -1,invocationCount = 2,testName = "A")
	public void createUser() {
		System.out.println("Created");
	}
    @Test(dependsOnMethods = "createUser")
	public void updateUser() {
		System.out.println("Updated");
	}
    @Test(enabled = true)
	public void deleteUser() {
		System.out.println("Deleted");
	}
	
}
