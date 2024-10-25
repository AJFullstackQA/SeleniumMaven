package TestCases.Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HandlingMultipleElements {

	public static void main(String[] args) throws InterruptedException {
		//Browser creation/launching
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to a URL
		//driver.navigate().to("");
		driver.get("https://www.saucedemo.com/");
		
		//Identify/Locate username textbox
		WebElement userNameTextBox = driver.findElement(By.id("user-name"));
		
		//Enter username into the textbox
		userNameTextBox.sendKeys("standard_user");
		Thread.sleep(2000);
		
		//Identify/Locate password textbox
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		
		//Enter the password into password textbox
		passwordTextBox.sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		//Construct a Relative Locator for the LoginButton
		WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.name("password")));
		
		//Click on the Login Button
		loginButton.click();
		Thread.sleep(2000);
		
		
		//Print all the available links
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(WebElement link : allLinks) {
			System.out.println(link.getText());
			//Select th elink which matches this text : Sauce Labs Onesie
			
			if(link.getText().equals("Sauce Labs Onesie")) {
				link.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
