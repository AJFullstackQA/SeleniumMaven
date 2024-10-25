package TestCases.Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkpoints {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver(); //ctrl+shift+o to add missing imports
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//Title Checkpoint using driver.getTitle()
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();	
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title Checkpoint/Verification has passed");
		}else {
			System.out.println("Title Checkpoint/Verification has not passed");
		}
			
		//Text Checkpoint
		String expectedText = "Accepted usernames are:";
		String actualText = driver.findElement(By.xpath("(//h4)[1]")).getText();
		if(actualText.equals(expectedText)) {
			System.out.println("Text Checkpoint/Verification has passed");
		}else {
			System.out.println("Text Checkpoint/Verification has not passed");
		}
		
		//Login into the application	
		//Locating the username  & Password textboxes
		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.name("password"));
		
		//Enter the username value
		userName.sendKeys("standard_user");
		Thread.sleep(2000);
		
		//Enter the password value
		password.sendKeys("secret_sau");
		Thread.sleep(2000);
		
		//Click on the login button
		driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
		Thread.sleep(5000);
		
		//Element checkpoint using try & catch blocks
//		try {
//		
//			driver.findElement(By.xpath("//div[@data-test='inventory-item-name'][text()='Sauce Labs Backpack']"));			
//		
//		}catch(NoSuchElementException e) {
//			
//			System.out.println(e);
//	
//		}
		
		//Element checkpoint using driver.findElements()
		List<WebElement> elementCheckpoint = driver.findElements(By.xpath("//div[@data-test='inventory-item-name'][text()='Sauce Labs Backpack']"));
		
		if(elementCheckpoint.size()>0) {
			System.out.println("Element checkpoint has passed");
		}else {
			System.out.println("Element checkpoint has not passed");
		}
		
		

		driver.close();
		

	}

}
