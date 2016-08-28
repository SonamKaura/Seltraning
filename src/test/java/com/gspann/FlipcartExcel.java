package com.gspann;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlipcartExcel {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	
	
	
	public Object [][] myDP() throws FileNotFoundException
	{
		Object [][] obj=null;
		fis=new FileInputStream("D:/Flipcart.xlsx");
		wb=new XSSFWorkbook();
		sheet=wb.getSheet("Sheet1");
		int totalrows=sheet.getLastRowNum();
		int totalcolumn=sheet.getRow(0).getLastCellNum();
		obj=new Object[totalrows][totalcolumn];
		int ci,cj;
		int startRow=1;
		int startCol=0;
		ci=0;
		for (int i=startRow;i<=totalrows;i++,ci++)
		{
		cj=0;
		for (int j=startCol;j<totalcolumn;j++,cj++)
		{
			obj [ci][cj]=getData(i,j);
		}
		
				}
		
		return obj;
	}
		public Object getData(int r , int c)
		{
			cell=sheet.getRow(r).getCell(c);
			int type=cell.getCellType();
			if (type==0)
			{
				return cell.getRawValue();
			}
			if(type==0)
			{
				return cell.getStringCellValue();
			}
			else{
				return null;
			}
		}
	
		
	}


