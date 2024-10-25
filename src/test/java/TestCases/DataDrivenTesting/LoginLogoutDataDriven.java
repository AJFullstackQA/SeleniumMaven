package TestCases.DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutDataDriven {

	public static void main(String[] args) throws InterruptedException {


		
		ExcelOperations xlOps = new ExcelOperations();
		int i = 1;
		try {
			// Create Object of ExcelOperations class & call the GetExcelData method
			int numberOfRows = xlOps.getRowCount("Sheet1");
			System.out.println("Row COunt is :" + numberOfRows);

			for (; i <= numberOfRows; i++) {
				String url = xlOps.getExcelData("Sheet1", i, 0);
				String uName = xlOps.getExcelData("Sheet1", i, 1);
				String pwd = xlOps.getExcelData("Sheet1", i, 2);

				// Create Chrome browser & load the URL
				ChromeDriver driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

				// Title Checkpoint to verify application actually loaded
				if (driver.getTitle().equals("Swag Labs")) {
					System.out.println("Title Verification passed");
				} else {
					System.out.println("Title Verification not passed");
					driver.quit();
				}

				// Login into the application
				driver.findElement(By.id("user-name")).sendKeys(uName);
				driver.findElement(By.id("password")).sendKeys(pwd);
				driver.findElement(By.id("login-button")).click();
				Thread.sleep(3000);

				// User Logs in & navigates to Dashboard page
				// Verify verify whether login was successful by inserting a text checkpoint
				if (driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]")).getText()
						.equals("Sauce Labs Backpack")) {
					System.out.println("User was successfully logged into the application");
				} else {
					System.out.println("User is not able to login into the application");
				}

				// Logout of the application
				// Click on the side menu
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.id("logout_sidebar_link")).click();
				Thread.sleep(3000);

				// Title Checkpoint to verify user was logged out
				if (driver.getTitle().equals("Swag Labs")) {
					System.out.println("Title Verification passed");
				} else {
					System.out.println("Title Verification not passed");
					driver.quit();
				}
				driver.quit();

				// Record the result [Pass / Fail] back to the Excel file
				xlOps.setExcelData("Sheet1", i, 3, "PASS");
			}
		
		} catch (Exception e) {
			System.out.println("Scenario has failed :");
			// Record the result [Pass / Fail] back to the Excel file
			xlOps.setExcelData("Sheet1", i, 3, "FAIL");
		}
	}

}
