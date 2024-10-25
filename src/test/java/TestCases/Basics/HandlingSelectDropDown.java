package TestCases.Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//Enter username
		WebElement userNameTextBox = driver.findElement(By.id("user-name"));
		userNameTextBox.sendKeys("standard_user");
		
		
		//Enter the password value
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		passwordTextBox.sendKeys("secret_sauce");
		
		
		//Alternate way to submit a form using submit()
		passwordTextBox.submit();
		Thread.sleep(3000);
		
		//Handling DropDown WebElement
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		
		Select select = new Select(dropDown);
		
		//Selecting an option from the dropdown
//		select.selectByIndex(1);
//		select.selectByValue("za");
		select.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		
		
		
		//Navigate to a different Application
		driver.navigate().to("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
		//Locate the MultiSelect dropdown
		WebElement multiSelect = driver.findElement(By.id("cars"));
		Select select1 = new Select(multiSelect);
		
		Boolean isMultiSelect = select1.isMultiple();
		
		if(isMultiSelect) {
			System.out.println("It is MultiSelect");
		}
		
		select1.selectByIndex(1);
		Thread.sleep(1000);
		select1.selectByValue("opel");
		Thread.sleep(1000);
		select1.selectByVisibleText("Audi");
		
		Thread.sleep(5000);
		
		//Mehtod to deselect all options from the dropdown
		select1.deselectAll();
		
		//Get All the options from the DropDown
		List<WebElement> allOptions = select1.getOptions();
		
		//Traditional for loop
//		for(int i=0; i<allOptions.size(); i++) {
//			System.out.println("Options in the drop down are :");
//			WebElement ele = allOptions.get(i);
//			System.out.println(ele.getText());
//		}
		
		//Using For-Each loop
		System.out.println("Options in the drop down are :");
		for(WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		//Select the first option
		select1.selectByIndex(0);
		Thread.sleep(1000);
		
		//Select the last option
		select1.selectByIndex(allOptions.size()-1);
		Thread.sleep(1000);
		
		
		//Print the selected options from the dropdown
		List<WebElement> allSelectedOptions = select1.getAllSelectedOptions();
		System.out.println("Selected Options are :");
		
		for(WebElement option : allSelectedOptions) {
			System.out.println(option.getText());
		}
		
		
		//Select all options from the Multiselect
		System.out.println("Selecting all the Options from the dropdown :");
		for(int i=0; i<allOptions.size()-1; i++) {
			select1.selectByIndex(i);
		}
		

		
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
