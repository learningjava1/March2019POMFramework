package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		//Is responsible to Fetch The data from Excel Sheet:
		//In order to Read Excel File, we Need to add all of Apache Poi Dependencies in pom.xml
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\hubspot\\testdata\\apptestdata.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		//Now we have to write a logic, so that we can get Data from rows and columns:
		//We're going to create 2 dimensional Object array
		Object data[][] = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//Now we have to fetch the Data, and we have to use 2 For Loops for 2 dimensional arrays:
		//1 for loop for Single Dimensional Array
		//One For Loop is for 'Rows', and the other is for 'Cols':
		
		for(int i = 0; i<sheet.getLastRowNum(); i++) {
			for(int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	
	}

}
