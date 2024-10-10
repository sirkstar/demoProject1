package com.assaaboly.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write2Excel {

	private XSSFWorkbook wb;
//	private Sheet sheet;
	private String filePath;
	
	public Write2Excel(String path) throws IOException {
		this.filePath = path;
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	}
	
	public void writeData(int sheetIndex, int row, int column, String Data) throws IOException{
		wb.getSheetAt(sheetIndex).getRow(row).createCell(column).setCellValue(Data);
		
		FileOutputStream fout = new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();
	}
	
}
