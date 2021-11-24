package test_script;

import org.testng.annotations.Test;

import generic.Excel;
import pom_webpages.Actitime_loginPage;

public class TestScript_01 extends SuperTest {

	@Test
	public void testmethod()
	{
		Actitime_loginPage rv= new Actitime_loginPage(driver);
		String user = Excel.readData("LoginPage", 1, 0);
		String pass = Excel.readData("LoginPage", 1, 1);
		rv.clickCheckbox();
		rv.clickLoginButton();
	}

	
}
