package TestCases.Popups;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		//Launching the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Locate the upload element
		//Create a File instance
		File toBeUploadedFile = new File("/Users/ajith/Desktop/Selenium4/SampleUpload.png");
		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		uploadFile.sendKeys(toBeUploadedFile.getAbsolutePath());
		
		
		
		//Click on the Upload FIle button
		WebElement uploadFileButton = driver.findElement(By.id("file-submit"));
		uploadFileButton.click();
		
		Thread.sleep(5000);
		
		//Verify that file was actually uploaded or not
		WebElement verificationElement = driver.findElement(By.xpath("//div[contains(text(),'SampleUpload.png')]"));
		String verificationElementText = verificationElement.getText();
		
		if(verificationElementText.contains("SampleUpload.png")) {
			System.out.println("Verification passed");
		}else {
			System.out.println("Verification not passed");
		}
		
		//Database Verification will also be performed in real time projects
		//
		
		
		
		driver.quit();
	}
}