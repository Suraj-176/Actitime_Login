package test_script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import generic.PropertyFile;
import generic.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SuperTest {

	public WebDriver driver;
	@Parameters("browsername")
	@BeforeClass
	public void selectBrowser(String browsername)
	{
		if(browsername.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyFile.getPropertyFile("appurl"));
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();		
	}
	
	public void getMethodExecutionValue(ITestResult result)
	{
		int status = result.getStatus();
		String execution_result = result.getName();
		if(status==1)
		{
			Reporter.log(result.getName()+"Execution Passed",true);
		}
		else if(status==2)
		{
			Reporter.log(result.getName()+"Executions Failed"+true);
			ScreenShot.getScreenshot(driver, execution_result);
		}
		else
		{
			Reporter.log(result.getName()+"Executions Skipped",true);
		}
		
	}
	
}
