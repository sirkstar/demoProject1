package com.assaaboly.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	private Sheet sheet;

	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//		

	//	}

	public ExcelDataProvider() {
		File src = new File("./DataProvider/TestData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void setSheet(int SheetIndex) {
		this.sheet=wb.getSheetAt(SheetIndex);
		
	}
	public String getStringData(int row, int column) {
		Row rowData = sheet.getRow(row);
		return rowData.getCell(column).getStringCellValue();
//		return setSheet(column);.getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(int sheetIndex, int row, int coloumn) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getNumericCellValue();
	}
}
