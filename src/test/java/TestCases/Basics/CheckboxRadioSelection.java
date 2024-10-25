package TestCases.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxRadioSelection {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); //ctrl+shift+o to add missing imports
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
		
		//Verify whether the checkbox is selected or not?	
		WebElement chkBox = driver.findElement(By.id("my-check-2"));
		Boolean isSelected = chkBox.isSelected();
		
		if(isSelected) {
			System.out.println("Checkbox is selected");
		}else {
			System.out.println("Checkbox is not selected");
		}
		
		
		//Verify whether the Radio button is selected or not?
		WebElement radioButton = driver.findElement(By.id("my-radio-2"));
		Boolean isRadioSelected = radioButton.isSelected();
		if(isRadioSelected) {
			System.out.println("RadioButton is selected");
		}else {
			System.out.println("RadioButton is not selected");
		}
		
		
		//Verify whether a webelement is enabled or disabled ?
		WebElement disabledElement = driver.findElement(By.name("my-textarea"));
		Boolean isEnabled = disabledElement.isEnabled();
		if(isEnabled) {
			System.out.println("TextBox is Enabled");
		}else {
			System.out.println("TextBox is Disabled");
		}
		
		
		//Verify whether a webElement is displayed or not ?
		WebElement hiddenElement = driver.findElement(By.name("my-textarea"));
		Boolean isDisplayed = hiddenElement.isDisplayed();
		if(isDisplayed) {
			System.out.println("TextBox is Displayed");
		}else {
			System.out.println("TextBox is not Displayed");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
