package com.tutorialsNija.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tutorialsNija.qa.utils.Utilities;

public class BaseTest {
	public static WebDriver driver;
	
	public Properties prop;
	public Properties dataProp;
	
	public  BaseTest() throws IOException {
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialNinja\\qa\\config\\config.properties");
		System.out.println(file.exists());
		FileInputStream fis=new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
		
		File dataFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\dataprop\\dataprop.properties");
		System.out.println(dataFile.exists());
		FileInputStream dataStream=new FileInputStream(dataFile);
		dataProp=new Properties();
		dataProp.load(dataStream);
	}
	
	public WebDriver initilizeBrowserAndOpenApplication(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public void captureScreenShot(String filename) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+filename);
		FileUtils.copyFile(src, dest);
	}


}
