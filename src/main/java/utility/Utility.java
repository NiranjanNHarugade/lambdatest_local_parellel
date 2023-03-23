package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	// Read data from property file
	public static String ReadPropertyFile(String Key) throws IOException 
	{
		FileInputStream Profile = new FileInputStream("C:\\Users\\Admin\\My-Workplace\\New_Maven\\dir");
		Properties pp = new Properties();
		pp.load(Profile);
		String Value = pp.getProperty(Key);
		return Value;
	}

	// Read data from Xcell file
	public static  String ReadXcell(int row ,int cell) throws EncryptedDocumentException, IOException
	{
	   	File data = new File ("C:\\All files\\MakeMyTrip\\EndToEnd.xlsx");
		String value = WorkbookFactory.create(data).getSheet("Sheet1").getRow(row).getCell(cell).toString();
		return value;	
	}
	
	

}

