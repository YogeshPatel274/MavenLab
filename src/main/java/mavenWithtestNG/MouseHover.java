package mavenWithtestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
WebDriver driver;
	@Test
	public void dragAndDrop()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions actions=new Actions(driver);
		//actions.dragAndDrop(drag, drop).build().perform();
		actions.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	}
}
