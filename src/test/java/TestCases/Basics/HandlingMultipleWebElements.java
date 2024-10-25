package TestCases.Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWebElements {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
		
		WebElement firtsMatchingElement = driver.findElement(By.xpath("//select[@id='cars']/option"));
		System.out.println("Attribute value of the FIrst Element is: "+firtsMatchingElement.getAttribute("value"));
		
		
		List<WebElement> allMatchingElements = driver.findElements(By.xpath("//select[@id='cars']/option"));
		
		System.out.println("Size of the Collection is : "+allMatchingElements.size());
		
		//Select all options from the dropdown
//		for(int i=1; i<allMatchingElements.size(); i++) {
//			WebElement element = allMatchingElements.get(i);
//			element.click();
//			Thread.sleep(1000);
//		}
		
		for(WebElement element:allMatchingElements) {
			element.click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
