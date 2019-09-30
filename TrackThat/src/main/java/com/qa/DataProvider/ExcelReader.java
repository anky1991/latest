package com.qa.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	   XSSFWorkbook wb;
	   XSSFSheet seet;
	   FileInputStream Fis;
	   
	public ExcelReader(String sheetpath)
	{
	   File F=new File(sheetpath);
	try
	{
	  Fis = new FileInputStream(F);
	} catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	   try 
	   {
		wb=new XSSFWorkbook(Fis);
	   }  
	   catch (IOException e) 
	 {
		e.printStackTrace();
	 }
	}
	
	public String getData(String sheetNumber, int row,int column)
	{
		   seet=wb.getSheetAt(0);
		   String data=seet.getRow(row).getCell(column).getStringCellValue();
		   return data;
	}
}
