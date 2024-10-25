package TestCases.Popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// Launching ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/iframes.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Verify the title of the Web-Page as a title Checkpoint
		String titleOfParentHTML = driver.getTitle();
		if(titleOfParentHTML.equals("This page has iframes")) {
			System.out.println("Parent HTML Title verification passed");
		}else {
			System.out.println("Parent HTML Title verification has not passed");
		}
		
		//Transfer the control of WebDriver to frame
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		
		//Enter Email, Age, and click on the Button
		WebElement email = driver.findElement(By.id("email"));
		WebElement age = driver.findElement(By.id("age"));
		WebElement button = driver.findElement(By.id("imageButton"));
		
		
		email.sendKeys("sample@mail.com");
		Thread.sleep(3000);
		age.sendKeys("10");
		Thread.sleep(3000);
		button.click();
		Thread.sleep(3000);
		
		
		//Transferring the control of WebDriver back to the parent HTMl
		driver.switchTo().defaultContent();
		
		
		//Checkpoint for verifying the text of the page
		WebElement headerTextElement = driver.findElement(By.xpath("//h1[text()='This is the heading']"));
		String headerText = headerTextElement.getText();
		
		if(headerText.equals("This is the heading")) {
			System.out.println("Text Verification has passed");
		}else {
			System.out.println("Text Verification has not passed");
		}
		
		
		//Close the browser window
		driver.quit();
		
		

	}
}