package TestCases.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubClass extends BaseClass {
	
	//Assertions
 
	@Test
	public void createBilling() {
		SoftAssert assertion = new SoftAssert();
		
		String expectedMsg = "Billing created successfully";
		System.out.println("Create Billing");
		String actualMsg = "Billing created successfully!!";
		
		
		//Verification
		Assert.assertEquals(actualMsg, expectedMsg);  //Hard assertion && Soft Assertion
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
