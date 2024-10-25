package TestCases.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAttributeValue {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//Verify the Placeholder attribute of username textbox & enter username
		WebElement userNameTextBox = driver.findElement(By.id("user-name"));
		
		String expectedPlaceHolder = "Username";
		String actualPlaceHolder = userNameTextBox.getAttribute("placeholder");
		
		if(actualPlaceHolder.equals(expectedPlaceHolder)) {
			userNameTextBox.sendKeys("standard_user");
		}
		
		
		//Enter the password value
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		passwordTextBox.sendKeys("secret_sauce");
		
		
		//Clear the textBox using clear()
		Thread.sleep(3000);
		passwordTextBox.clear();
		
		Thread.sleep(3000);
		passwordTextBox.sendKeys("secret_sauce");
		
		
		//Alternate wau to submit a form using submit()
		passwordTextBox.submit();
		
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		
		
		

	}

}
