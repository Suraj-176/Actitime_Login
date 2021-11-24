package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot implements Utlitly
{
	public static void getScreenshot(WebDriver driver, String imagename)
	{
		Date d=new Date();
		SimpleDateFormat date_format=new SimpleDateFormat("dd_MM-yyyy");
		String execution_date = date_format.format(d);
		TakesScreenshot s=(TakesScreenshot)driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dest=new File(image_path+imagename+"_"+execution_date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
	
		}
	}

}
