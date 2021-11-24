package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements Utlitly
{
	static Workbook book;
	static Row row;
	static Cell cell;
	
	public static String readData(String sheetname, int rownum,int cellnum)
	{
		try 
		{
			book=WorkbookFactory.create(new FileInputStream(excel_path));
		}
		 catch (Exception e) 
		{
			
		}
		return book.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	}
	
	public static void writeData(String sheetname, int rownum,int cellnum,String value)
	{
		try
		{
			book=WorkbookFactory.create(new FileInputStream(excel_path));
		}
		catch (Exception e) 
		{
			
		}
		book.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(value);
		try 
		{
			book.write(new FileOutputStream(excel_path));
		} 
		catch (Exception e)
		{
			
		}
	}

}
