package TestCases.Popups;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserPopup {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the browser & load the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get the window handle of the parent browser
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);
		
		//Clickon the link to open the new window
		WebElement neWindowLink = driver.findElement(By.xpath("//a[text()='new window']"));
		
		//Scroll the application till the element becomes visible
		Actions actions = new Actions(driver);
		actions.moveToElement(neWindowLink).perform();
		Thread.sleep(3000);
		
		neWindowLink.click();
		Thread.sleep(5000);
		
		//Get the windowHanldes of all the browser tabs
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		
		//Read the window Handles from the Set collection by creating an Iterator for Set
		Iterator<String> iterator = windowHandles.iterator();
		
		//Fetch the parent & Child window handles
		String parentWindowHaandle = iterator.next();
		String childWindowHaandle = iterator.next();
		
		System.out.println("Parent Window Handle : "+parentWindowHaandle);
		System.out.println("Child Window Handle : "+childWindowHaandle);
		
		//Transfer the control of driver to child browser window
		driver.switchTo().window(childWindowHaandle);
		
		//Verify the Title of the Child window
		String childWindowTitle = driver.getTitle();
		System.out.println("Return of Title method is : "+childWindowTitle);
		
		if(childWindowTitle.equals("Selenium")) {
			System.out.println("Child Window Tilte verification passed");
		}else {
			System.out.println("Child Window Tilte verification not passed");
		}
		

		
		//Closing the browser windows
		driver.close();
		Thread.sleep(3000);
		
		driver.switchTo().window(parentWindowHaandle);
		driver.close();
	}

}