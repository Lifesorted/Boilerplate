package com.Boilerplate.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	
	static File src=new File(System.getProperty("user.dir")+"/TestData/TestDataFile.xlsx");
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	public static String getSearchData() {
		try {
			fis= new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheetAt(0);
		String searchData=sheet.getRow(0).getCell(0).getStringCellValue();
		return searchData;
	}
	
	public static void main(String []args) {
		System.out.println(GetExcelData.getSearchData());
	}

}
