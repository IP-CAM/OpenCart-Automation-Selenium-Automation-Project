package org.renuka.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileUsingPOI {

	private static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws IOException {
		String[][] arrData = null;
		try {
			// Create an object of File class to open xlsx file

			File file = new File(Constants.TESTDATA_PATH);

			// Create an object of FileInputStream class to read excel file

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = null;

			// Find the file extension by splitting file name in substring and getting only
			// extension name

			String fileExtensionName = Constants.TESTDATA_PATH.substring(Constants.TESTDATA_PATH.indexOf("."));

			// Check condition if the file is xlsx file

			if (fileExtensionName.equals(".xlsx")) {

				// If it is xlsx file then create object of XSSFWorkbook class
				workbook = new XSSFWorkbook(inputStream);

			}

			// Check condition if the file is xls file

			else if (fileExtensionName.equals(".xls")) {

				// If it is xls file then create object of XSSFWorkbook class

				workbook = new HSSFWorkbook(inputStream);

			}

			// Read sheet inside the workbook by its name

			sheet = workbook.getSheet(sheetName);

			// Find number of rows in excel file
			int totalRows = sheet.getLastRowNum();
			// Find number of columns in excel file
			int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
			// Set the Array Size
			arrData = new String[totalRows][totalCols];
			int startRow = 1;
			int startCol = 0;
			Row row = null;
			Cell cell = null;
			for (int i = startRow; i <= totalRows; i++) {
				row = sheet.getRow(i);
				for (int j = startCol; j < totalCols; j++) {
					cell = row.getCell(j);
					arrData[i - 1][j] = cell.toString();
				}

			}

		} catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}
		return arrData;
	}

}
