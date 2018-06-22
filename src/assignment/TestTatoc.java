package assignment;
import static org.testng.Assert.assertEquals;

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
		assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/drag");
	}
	  
	@Test (dependsOnMethods = {"test_Frame_Dungeon"})
	public void test_Task_Drag_Around()
	{
		automate_Task_Drag_Around();
		assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/windows");
	}
	  
	@Test (dependsOnMethods = {"test_Task_Drag_Around"})
	public void test_Task_Popup_Windows()
	{
		automate_Task_Popup_Windows();
		assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/cookie");
	}
	  
	@Test (dependsOnMethods = {"test_Task_Popup_Windows"})
	public void test_Task_Cookie_Handling()
	{
		automate_Task_Cookie_Handling();
		assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/end");
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