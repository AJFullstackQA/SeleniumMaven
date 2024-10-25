package TestCases.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Login into the application");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout of the application");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Launch the application URL");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Close the application");
	}

//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("Establish some Connections like, Grid OR DB");
//	}
//
//	@AfterTest
//	public void afterTest() {
//		System.out.println("Establish some Connections like, Grid OR DB");
//	}
//
//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("Launch the Browser");
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("Close the Browser");
//	}

}
