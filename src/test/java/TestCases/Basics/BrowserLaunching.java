package TestCases.Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public class BrowserLaunching {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		//Use Driver executables & set the path of those driver executables 
		//in the driver creation class	
		//WebDriverManager class -- 	
		//SeleniumManager class -- Introduced in 4.6.0 version
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//		Thread.sleep(5000);
//		System.out.println(driver.getCurrentUrl());
//		driver.quit();	
//		driver = new FirefoxDriver();
		
		
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		Thread.sleep(2000);
		
		//Alternate approach for loading a URL
		driver.navigate().to("https://www.selenium.dev/downloads/");
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.selenium.dev/documentation/");
		Thread.sleep(2000);
		
		//Clicking the Back button in the browser menu
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Clicking the forward button in the browser menu
		driver.navigate().forward();
		Thread.sleep(2000);
		
		//Reload the WebPage 
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Put the Browser in FullScreen
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		
		//Minimise the browser window
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
		//Fetch the contents of the title tag in the html tree
		System.out.println(driver.getTitle());
		
		System.out.println();
		
		//Fetch the entire html tree structure
		System.out.println(driver.getPageSource());
		
		driver.quit();
		
		
		
	
	}

}
