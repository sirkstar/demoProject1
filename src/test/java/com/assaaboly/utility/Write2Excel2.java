package com.assaaboly.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write2Excel2 {
	private XSSFWorkbook wb;
	private String filePath;
	
	public Write2Excel2(String path) throws IOException {
		this.filePath=path;
		File src = new File(filePath);
		try{
			FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		}catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
	
	public void writeDate(int sheetIndex, int row, int column, String data) throws IOException {
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		
		if(sheet.getRow(row)==null) {
			sheet.createRow(row);
		}
		if(sheet.getRow(row).getCell(column)!=null) {
			sheet.getRow(row).getCell(column).setCellValue("");
		}
		sheet.getRow(row).createCell(column).setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();		
	}
	

}
