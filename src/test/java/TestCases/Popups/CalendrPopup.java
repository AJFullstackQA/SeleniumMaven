package TestCases.Popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendrPopup {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		Thread.sleep(10000);
		
		
		//Open the Calendar popup by clicking on the date element
		WebElement calendar = driver.findElement(By.xpath("//*[contains(text(),'Departure Date')]/preceding-sibling::input"));
		calendar.click();
		
		Thread.sleep(5000);
		
		//Select a date from the Calendar popup
		WebElement date = driver.findElement(By.id("19/10/2024"));
		date.click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		
		
		
		
		
	}
}