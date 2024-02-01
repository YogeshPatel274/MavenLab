package mavenWithtestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {
	WebDriver driver;
	@Test
	public void switchWin()
	{
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_openwindow");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		Set<String> allWins=driver.getWindowHandles(); 
		System.out.println("Total Windows="+allWins.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWins.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Win1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Win2 title="+driver.getTitle());
		boolean chkLogEnbl=driver.findElement(By.linkText("Sign Up")).isEnabled();
		if(chkLogEnbl==true)
		{
			System.out.println("Login Enable..");
		}
		driver.quit();
		}
}
