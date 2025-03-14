package com.tutorialsNinja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNija.qa.utils.ExtentReporter;
import com.tutorialsNija.qa.utils.Utilities;

public class MyListeners implements ITestListener{

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
			try {
				extentReport=ExtentReporter.generateExtentReport();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
		extentTest=extentReport.createTest(testName)
				.log(Status.INFO, testName+" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testName=result.getName();
		extentTest=extentReport.createTest(testName)
		.log(Status.PASS, testName+" got successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testName=result.getName();
		try {
			extentTest=extentReport.createTest(testName)
			.log(Status.FAIL, testName+" got failed").addScreenCaptureFromPath(Utilities.captureScreenshot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentReport.createTest(testName)
			.log(Status.FAIL, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(Utilities.captureScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testName=result.getName();
		extentTest=extentReport.createTest(testName)
		.log(Status.SKIP, testName+" got failed");
	}

	

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("Execution completed");
	extentReport.flush();
	try {
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html").toURI());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}
