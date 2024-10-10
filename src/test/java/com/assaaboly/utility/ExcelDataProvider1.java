package com.assaaboly.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	XSSFWorkbook wb;
	private Sheet sheet;

	public ExcelDataProvider1() {		
		File src = new File("./DataProvider/TestData.xlsx"); // define the File path
		try {
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
	
	public void setSheet(int sheetIndex) {
		this.sheet = wb.getSheetAt(sheetIndex);
	}
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public void close() {
		try {
		if(wb!=null) {
			wb.close();
		}
		}catch(IOException e) {
			System.out.println("Exception: "+e);
		}
	}
}
