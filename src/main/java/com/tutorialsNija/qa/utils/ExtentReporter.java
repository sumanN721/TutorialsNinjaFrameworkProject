package com.tutorialsNija.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException
	{
		ExtentReports extentReport=new ExtentReports();
		File file=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(file);
		sparkreporter.config().setTheme(Theme.STANDARD);
		sparkreporter.config().setDocumentTitle("TN Automation report");
		sparkreporter.config().setReportName("TUTORIALS NINJA TEST AUTOMATION");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkreporter);
		
		File configFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialNinja\\qa\\config\\config.properties");
		FileInputStream fis=new FileInputStream(configFile);
		Properties prop=new Properties();
		prop.load(fis);
		
		extentReport.setSystemInfo("Application URl", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Email", prop.getProperty("username"));
		extentReport.setSystemInfo("Password", prop.getProperty("password"));
		extentReport.setSystemInfo("Operating system", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return extentReport;
		
		
		
		
	}
}
