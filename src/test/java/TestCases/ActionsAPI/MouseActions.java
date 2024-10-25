package TestCases.ActionsAPI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the chrome browser and load the url
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Mouse Events : left click, double click, right click (context click)
		WebElement mouseEventElement = driver.findElement(By.id("clickable"));
		Actions action = new Actions(driver);
		
		
		//Left click
		action.click(mouseEventElement).perform();
		Thread.sleep(3000);
		
		//Double click
		action.doubleClick(mouseEventElement).perform();
		Thread.sleep(3000);
		
		//Right click
		action.contextClick(mouseEventElement).perform();
		Thread.sleep(3000);
		
		//Move the focus to an element
		WebElement mouseMovementElement = driver.findElement(By.id("mouse-tracker"));
		action.moveToElement(mouseMovementElement).perform();
		Thread.sleep(3000);
		
		
		//Drag & Drop operation
		WebElement draggableElement = driver.findElement(By.id("draggable"));
		WebElement droppableElement = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(draggableElement, droppableElement).perform();
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
}