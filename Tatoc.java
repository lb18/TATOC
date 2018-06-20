package test;

public class Tatoc
{
	public static void main (String args[])
	{
		Implementation obj = new Implementation();
		obj.automate_Task_GridGate();
		obj.automate_Task_Frame_Dungeon();
		obj.automate_Task_Drag_Around();
		obj.automate_Task_Popup_Windows();
		obj.automate_Task_Cookie_Handling();
	}
}


/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 			// firefox.FirefoxDriver for firefox
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;

public class Tatoc {

	public static void main (String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		driver.switchTo().frame("main");
		String str = driver.findElement(By.id("answer")).getAttribute("className"), str2;
		while (true)
		{
			driver.switchTo().frame("child");
			str2 = driver.findElement(By.id("answer")).getAttribute("className");
			if (str.equalsIgnoreCase(str2)) 
			{
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Proceed")).click();
				break;
			}
			driver.switchTo().parentFrame();
			driver.findElement(By.linkText("Repaint Box 2")).click();
		}
		Actions act = new Actions(driver);	
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		act.dragAndDrop(from, to).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String MainWindow = driver.getWindowHandle();
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
	            		break;
			}
		}
		driver.switchTo().window(MainWindow);
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Generate Token")).click();
		String Cookie_val = driver.findElement(By.id("token")).getText();
		Cookie ck = new Cookie("Token", Cookie_val.substring(7));
		driver.manage().addCookie(ck);
		driver.findElement(By.linkText("Proceed")).click();
	}
}*/
