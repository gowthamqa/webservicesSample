package com.qa.common.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelManager {

	Workbook workbook = null;
	Sheet sheet = null;

	public ExcelManager() {
		init("productdata.xlsx", "Sheet2");
	}

	/*public ExcelManager(String filePath) {
		init(filePath, "Sheet1");
	}*/
	
	public ExcelManager(String sheetName) {
		init("productdata.xlsx", sheetName);
	}

	public ExcelManager(String filePath, String sheetName) {
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

	public void readData(int rowNumber) {

		Row row = sheet.getRow(rowNumber);
		Cell cell = null;

		for (int i = 0; i < row.getLastCellNum(); i++) {
			cell = row.getCell(i);
			String value = getData(cell);
			System.out.println(value);
		}

	}
	
	public String readData(int rowNumber, String colName) {
		
		Row indexRow = sheet.getRow(0);
		Row row = sheet.getRow(rowNumber);
		Cell cell = null;
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if(indexRow.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				cell = row.getCell(i);
				String value = getData(cell);
				System.out.println(value);				
			}			
		}
		System.out.println(getData(cell));	
		return getData(cell);
		
	}
	

	private String getData(Cell cell) {
		String value = "";
		CellType cellT = cell.getCellType();
		switch (cellT) {
		case NUMERIC:
			int db = (int) cell.getNumericCellValue();
			value = String.valueOf(db);
			break;
		case STRING:
			value = cell.getStringCellValue();
			break;
		case BOOLEAN:
			boolean b = cell.getBooleanCellValue();
			value = String.valueOf(b);
			break;
		case BLANK:
			value = "";
			break;
		case FORMULA:
			value = cell.getCellFormula();
			break;
		default:
			value = "";
			break;
		}

		return value;
	}

	public static void main(String[] args) {
		ExcelManager ex = new ExcelManager();
		System.out.println(ex.totalRows());
		System.out.println(ex.totalColumns());
		ex.readData(1);
		ex.readData(1,"totalQty");
	}

	
}
