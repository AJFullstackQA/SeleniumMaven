package TestCases.Selenium4Features;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Make use of a class called ChromeOptions
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
//		opt.setAcceptInsecureCerts(true);
//		opt.addArguments("disable-infobars");
//		
		opt.addArguments("window-size=1400,1000");
		
//		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		//Browser in Incogito mode
//		opt.addArguments("incognito");
//		
//		
//		//launching the browser with Mobile View of the WebPage
//		Map<String, String> mobileView = new HashMap<String, String>();
//		mobileView.put("deviceName", "iPhone X");
//		
//		opt.setExperimentalOption("mobileEmulation", mobileView);
		
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		
		
		

		// Create Chrome browser & load the URL
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.flipkart.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		// We can take screenshot at Element level & page level
//		WebElement userNameTxtBox = driver.findElement(By.id("user-name"));
//		WebElement passwordTxtBox = driver.findElement(By.id("password"));
		
		//Print the title of the WebPage
		System.out.print(driver.getTitle());
		WebElement cart = driver.findElement(By.xpath("//*[text()='Cart']"));
		
		cart.click();

//		// Enter username & take screenshot of textbox
//		userNameTxtBox.sendKeys("standard_user");
//
//		// Enter username & take screenshot of textbox
//		passwordTxtBox.sendKeys("secret_sauce");
//		
//		
//		// Close the browser window
		Thread.sleep(3000);
		driver.quit();

	}

}
