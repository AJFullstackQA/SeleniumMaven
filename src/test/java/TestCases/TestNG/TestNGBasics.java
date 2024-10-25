package TestCases.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@Test()
	public void firstTest() {
		System.out.println("First TestNG Test");
	}
	
	@Test(enabled=false)
	public void secondTest() {
		System.out.println("Second TestNG Test");
	}
	
	@Test()
	public void thirdTest() {
		System.out.println("Third TestNG Test");
	}
	
	
}
