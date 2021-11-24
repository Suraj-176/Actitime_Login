package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile implements Utlitly
{
	public static String getPropertyFile(String key)
	{
		Properties p=new Properties();
		try 
		{
			p.load(new FileInputStream(propertyFile_path));
		} 
		catch (Exception e) 
		{
			
		}
		return p.getProperty(key);
		
	}

}
