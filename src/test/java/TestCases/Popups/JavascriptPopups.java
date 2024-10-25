package TestCases.Popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPopups {

	public static void main(String[] args) throws InterruptedException {

		// Launcing the url
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

		// First open the popup by clicking on the link
		WebElement alertPopupLink = driver.findElement(By.xpath("//a[text()='See an example alert']"));
		alertPopupLink.click();
		Thread.sleep(3000);

		// Handle the Alert popup
		String alertPopupMessage = driver.switchTo().alert().getText();
		if (alertPopupMessage.contains("Sample alert")) {
			System.out.println("Alert Text has been verified successfully!");
		} else {
			System.out.println("Alert Text has been not been verified!");
		}

		// Click on the OK button present in the popup
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		// Handling Confirmation Popup
		// Locate the Confirmation popup link
		WebElement confimationPopupLink = driver
				.findElement(By.xpath("(//h2[@id='confirm']/following-sibling::p)[1]/a"));

		// open the popup by clicking on the link
		confimationPopupLink.click();
		Thread.sleep(3000);

		// Handle the Confirmation popup
		String confirmationPopupMessage = driver.switchTo().alert().getText();
		if (confirmationPopupMessage.contains("Are you sure?")) {
			System.out.println("Confirm Text has been verified successfully!");
		} else {
			System.out.println("Confirm Text has been not been verified!");
		}
		
		//Click on the cancel button to close it
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
		//Open the confirm popup once again
		confimationPopupLink.click();
		Thread.sleep(3000);
		
		//Click on the OK button to close it
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		

		driver.quit();

	}

}