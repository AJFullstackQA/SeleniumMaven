package TestCases.Selenium4Features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;


public class TakingScreenshots {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Create Chrome browser & load the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		// We can take screenshot at Element level & page level
		WebElement userNameTxtBox = driver.findElement(By.id("user-name"));
		WebElement passwordTxtBox = driver.findElement(By.id("password"));

		// Enter username & take screenshot of textbox
		userNameTxtBox.sendKeys("standard_user");

		File uNameElementScreenshot = userNameTxtBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(uNameElementScreenshot,
				new File("./src/test/resources/screenshots/uNameElementScreenshot.jpg"));

		// Enter username & take screenshot of textbox
		passwordTxtBox.sendKeys("secret_sauce");

		File pwdElementScreenshot = passwordTxtBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pwdElementScreenshot,
				new File("./src/test/resources/screenshots/pwdElementScreenshot.jpg"));
		
		
		//Page level screenshot
		File fullePageScreenshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fullePageScreenshot,
				new File("./src/test/resources/screenshots/fullePageScreenshot.jpg"));
		
		
		//TakeScreenShot
		//Save the WebPage as a PDF file
		Pdf pdf = driver.print(new PrintOptions());
		Files.write(Paths.get("./src/test/resources/screenshots/sauceDemo.pdf"), 
				OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		
		
		
		

		// Close the browser window
		Thread.sleep(3000);
		driver.quit();

	}

}
