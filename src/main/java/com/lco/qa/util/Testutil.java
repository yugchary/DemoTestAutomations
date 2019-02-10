package com.lco.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lco.qa.base.TestBase;

public class Testutil extends TestBase {

	public static long pageLoadTimeout = 180;
	public static long implicitlyWait = 180;
	public static long waitTime = 5000;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\akkyu01\\eclipse-workspace\\Google.xlsx";

	static Workbook book;
	static Sheet sheet;

	static XSSFCell Cell;

	static XSSFRow Row;

	public static Object[] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[] data = new Object[sheet.getLastRowNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i]);
			}
		}
		return data;

	}

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;
		Xlsutil xl = new Xlsutil(TESTDATA_SHEET_PATH);

		int startRow = 2;

		int startCol = 1;

		int ci, cj;

		//int totalRows = sheet.getLastRowNum();
		
		int totalRows = xl.getRowCount(SheetName);

		// you can write a function as well to get Column count

		//int totalCols = 3;
		
		int totalCols = xl.getColumnCount(SheetName);
		
		//int totalCols = sheet.getCol

		tabArray = new String[totalCols][totalRows-1];

		ci = 0;

		for (int i = startRow; i <= totalRows; i++, ci++) {

			cj = 0;

			for (int j = startCol; j <= totalCols; j++, cj++) {

				//tabArray[ci][cj] = getCellData(i, j);
				
				tabArray[ci][cj] = xl.getCellData(SheetName, j-1, i);
				

				System.out.println(tabArray[ci][cj]);

			}

		}

		return (tabArray);

	}
	
	
	
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		 
		 try{
		 
		 Cell = (XSSFCell) sheet.getRow(RowNum).getCell(ColNum);
		 
		 int dataType = Cell.getCellType();
		 
		 if  (dataType == 3) {
		 
		 return "";
		 
		 }else{
			 
			
		 
		 //String CellData = Cell.getStringCellValue();
		 
		 String CellData = Cell.getRawValue();
		 
		 return CellData;
		 
		 }
		 }catch (Exception e){
		 
		 System.out.println(e.getMessage());
		 
		 throw (e);
		 
		 }
		 
		 }
	
	
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
