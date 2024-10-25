package TestCases.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Billing {
	
	@Test
	public void createBilling() {
		System.out.println("Create Billing");
	}
	
	@Test(dependsOnMethods= {"createBilling"})
	public void editBilling() {
		System.out.println("Edit Billing");
	}
	
	@Test(dependsOnMethods= {"editBilling"})
	public void deleteBilling() {
		System.out.println("Delete Billing");
	}
	
	
}
