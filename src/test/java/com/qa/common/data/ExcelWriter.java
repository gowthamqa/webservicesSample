package com.qa.common.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;


public class ExcelWriter {

	private static final CellType STRING = null;
	Workbook workbook = null;
	Sheet sheet = null;
	//public int headerCellCount;

	public ExcelWriter() {
		init("D:\\Test.xlsx", "Sheet1");
	}
	
	public ExcelWriter(String sheetName) {
		init("productdata.xlsx", sheetName);
	}

	public ExcelWriter(String filePath, String sheetName) {
		init(filePath, sheetName);
	}

	private void init(String filePath, String sheetName) {

		File file = new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			if(filePath.contains(".xlsx")) {
				workbook = new XSSFWorkbook(fis);
			}else {
				workbook = new HSSFWorkbook(fis);
			}
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public int totalRows() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int totalColumns() {
		Row row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	public int getHeaderCellCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	private String getCellValue(int index, JSONObject valueObject) {
		String value = ""; 
		if(index == 0) {
			value = valueObject.getString("driverId");
		} else if(index == 1) {
			value = valueObject.getString("givenName") + " " + valueObject.getString("familyName");
		} else if(index == 2) {
			value = valueObject.getString("dateOfBirth");
		} else if(index == 3) {
			value = valueObject.getString("nationality");
		}
		return value;
	}
	
	public void writeData(int rowCount, JSONObject value) {
		Row row = sheet.createRow(rowCount);
		for (int j = 0; j < 4; j++) {
			Cell cell = row.createCell(j);
			cell.setCellValue(getCellValue(j, value));
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:\\Test.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*public static void main(String[] args) throws IOException {
		ExcelWriter ex = new ExcelWriter();
		System.out.println(ex.totalRows());
		System.out.println(ex.totalColumns());
		ex.writeData(16384,"I love India");
		
	}*/

	
}
