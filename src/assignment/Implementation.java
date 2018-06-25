package assignment;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Implementation
{
	public WebDriver driver = new ChromeDriver();
	
	Implementation()
	{
		driver.get("http://10.0.1.86/tatoc");
	}
	
	void error_Page()
	{
		driver.get("http://10.0.1.86/tatoc/error");
	}
	
	public void automate_Task_GridGate()
	{
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
	}

	public boolean Repaint_Until_Both_Boxes_Have_Same_Color(String str)
	{
		while (true)
		{
			driver.switchTo().frame("child");
			String str2 = driver.findElement(By.id("answer")).getAttribute("className");
			if (str.equals(str2)) 
			{
				driver.switchTo().parentFrame();
				return true;
			}
			driver.switchTo().parentFrame();
			driver.findElement(By.linkText("Repaint Box 2")).click();
		}
		//return false;
	}
	
	public void automate_Task_Frame_Dungeon()
	{
		driver.switchTo().frame("main");
		String str = driver.findElement(By.id("answer")).getAttribute("className");
		if (Repaint_Until_Both_Boxes_Have_Same_Color(str))
			driver.findElement(By.linkText("Proceed")).click();
		else error_Page();
	}
	
	void check_If_Drop_Contains_Drag()
	{
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	public void automate_Task_Drag_Around()
	{
		Actions act = new Actions(driver);	
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		act.dragAndDrop(from, to).build().perform();
		check_If_Drop_Contains_Drag();
	}
	
	// returns true if the i/p field is filled and false if it is left empty
	public boolean check_Input_Field(String MainWindow)
	{
		boolean flag = false;
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			// next -> returns next element
			String ChildWindow = it.next();	
			driver.switchTo().window(ChildWindow);	
			if(!MainWindow.equalsIgnoreCase(ChildWindow))	
			{                                                                                                  
	           		driver.findElement(By.id("name")).sendKeys("lokesh");
	            	driver.findElement(By.id("submit")).click();
	            	flag = true;
			}
		}
		driver.switchTo().window(MainWindow);
		return flag;
	}
	
	public void automate_Task_Popup_Windows()
	{
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String MainWindow = driver.getWindowHandle();
		if (check_Input_Field(MainWindow))	
			driver.findElement(By.linkText("Proceed")).click();
		else error_Page();
	}
	
	public void automate_Task_Cookie_Handling()
	{
		driver.findElement(By.linkText("Generate Token")).click();
		String Cookie_val = driver.findElement(By.id("token")).getText();
		Cookie ck = new Cookie("Token", Cookie_val.substring(7));
		driver.manage().addCookie(ck);
		driver.findElement(By.linkText("Proceed")).click();
	}
}
