package assignment;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestTatoc extends Implementation
{
	
	@Test
	public void test_Grid_Gate()
	{
		automate_Task_GridGate();
		String URL = driver.getCurrentUrl();
		assertEquals(URL, "http://10.0.1.86/tatoc/basic/frame/dungeon");
	}
	  
	@Test (dependsOnMethods = {"test_Grid_Gate"})
	public void test_Frame_Dungeon()
	{
		automate_Task_Frame_Dungeon();
		WebElement get_id_name = driver.findElement(By.id("dropbox"));
		assertEquals(get_id_name.getText(), "DROPBOX");
	}
	  
	@Test (dependsOnMethods = {"test_Frame_Dungeon"})
	public void test_Task_Drag_Around()
	{
		automate_Task_Drag_Around();
		WebElement get_the_text_of_first_heading = driver.findElement(By.cssSelector("body > div > div.page > h1"));
		System.out.println(get_the_text_of_first_heading.getText());
		
		// contains(substr) returns true if a string contains substring 'substr'
		assertEquals(get_the_text_of_first_heading.getText().contains("Pop"), true);
	}
	  
	@Test (dependsOnMethods = {"test_Task_Drag_Around"})
	public void test_Task_Popup_Windows()
	{
		automate_Task_Popup_Windows();
		WebElement get_link_text = driver.findElement(By.linkText("Generate Token"));
		Assert.assertTrue(get_link_text.getText().contains(" Tok"));
	}
	  
	@Test (dependsOnMethods = {"test_Task_Popup_Windows"})
	public void test_Task_Cookie_Handling()
	{
		automate_Task_Cookie_Handling();
		assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/end");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	// test for checking the flow of execution of methods in Implementation class
	@Test(priority = 1) 
	void test_page1() {automate_Task_GridGate();}
	
	@Test(priority = 2)
	void test_page2() {automate_Task_Frame_Dungeon();}
	
	@Test(priority = 3)
	void test_page3() {automate_Task_Drag_Around();}
	
	@Test(priority = 4) 
	void test_page4( ) {automate_Task_Popup_Windows();}
	
	@Test(priority = 5) 
	void test_page5() {automate_Task_Cookie_Handling();}
}
