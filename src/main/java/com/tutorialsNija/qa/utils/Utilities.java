package com.tutorialsNija.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.tutorialsNija.qa.base.BaseTest;


public class Utilities extends BaseTest{ 
	public Utilities() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;

	public static  String generateEmailWithTimestamp()
	{
		Date date=new Date();
		String timestamp= date.toString().replace(" ","_").replace(":", "_");
		return "suman"+timestamp+"@gmail.com";
	}
	
	public static String[][] getTestDatafromExcel(String sheet) throws IOException
	{
		File file=new File("K:\\suman.xlsx");
		System.out.println(file.exists());
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1=workbook.getSheet(sheet);
		int row=sheet1.getLastRowNum();
		int col=sheet1.getRow(0).getLastCellNum();
		System.out.println(row+""+col);
		
		String[][] dataSupply= new String[row-1][col];
		for(int i=0;i<row-1;i++)
		{
			for(int j=0;j<col;j++)
			{
				DataFormatter df=new DataFormatter();
				dataSupply[i][j]=df.formatCellValue(sheet1.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return dataSupply;
	}
	
	
	public static String captureScreenshot() throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./google123765.png");
		FileUtils.copyFile(src, dest);
		String path=dest.getAbsolutePath();
		return path;
	}
}
