package TestCases.ActionsAPI;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the chrome browser and load the url
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Creating the reference of Actions class
		Actions action = new Actions(driver);
		
		//Press the tab buttonof the keyboard
		action.keyDown(Keys.TAB).perform();
		
		//Enter username in the textbox
		action.sendKeys("standard_user").perform();
		
		//Press tab to shift control to Username Textbox
		action.keyDown(Keys.TAB).perform();
		
		//Enter password in the textbox
		action.sendKeys("secret_sauce").perform();
		
		//Press tab to shift control to the Login button
		action.keyDown(Keys.TAB).perform();
		
		//Press the enter Key to click on the login button
		action.keyDown(Keys.ENTER).perform();
		
		
		
		//Composite events coupling
//		action.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ENTER).perform();
		
		
	
		Thread.sleep(3000);
		driver.quit();
		
		
	}
}