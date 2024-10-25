package TestCases.Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		
		//Create Chrome browser & load the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		//Title Checkpoint to verify application actually loaded
		if(driver.getTitle().equals("Swag Labs")) {
			System.out.println("Title Verification passed");
		}else {
			System.out.println("Title Verification not passed");
			driver.quit();
		}
			
		//Login into the application
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000), Duration.ofMillis(500));
		
		//FluentWait = Introduce some time gap between successive element checking
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
		WebElement textElement = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]"));
		wait1.until(ExpectedConditions.elementToBeClickable(textElement));
		
		
		
		//User Logs in & navigates to Dashboard page
		//Verify verify whether login was successful by inserting a text checkpoint
		if(driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]")).getText().equals("Sauce Labs Backpack")) {
			System.out.println("User was successfully logged into the application");
		}else {
			System.out.println("User is not able to login into the application");
		}
		
		
		//Logout of the application
		//Click on the side menu
		driver.findElement(By.id("react-burger-menu-btn")).click();
//		Thread.sleep(3000);
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		
		
		wait1.until(ExpectedConditions.elementToBeClickable(logoutButton));
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		
		//Title Checkpoint to verify user was logged out
		if(driver.getTitle().equals("Swag Labs")) {
			System.out.println("Title Verification passed");
		}else {
			System.out.println("Title Verification not passed");
			driver.quit();
		}
		
		driver.quit();
	}

}
