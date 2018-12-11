package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base_Class {
	
	public static Process process;
	public static AppiumDriver driver;
	
	//Start server
	public static void Start_Server() throws IOException, InterruptedException 
	{
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		 process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Appium Server is Started");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(12000);
		
	}
	
	
	//Initiliaze app
	public static void Initialize_app() throws InterruptedException, MalformedURLException
	{
		//Launch app
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName", "BLN-L22");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.2");
		
		//app details
		capabilities.setCapability("appPackage", "ae.propertyfinder.propertyfinder");
		capabilities.setCapability("appActivity", "ae.propertyfinder.consumer.ui.activity.ConfigurationA");
		
		//appium server details
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
		
		Thread.sleep(8000);
		
		
	}
	
	//Explicit wait
	
	public void Explicitwait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	//Screenshot
	
	public void Snapshot1(String TC_ID,String Order) throws IOException 
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(df.format(date)+".png");
		
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Dec16_Project\\Screenshot\\"+TC_ID+"-"+Order+"-"+file));
		
	}
	
	
	
	//Stop server
	
	public static void Stop_Server() throws InterruptedException
	{
		
		if(process!=null)
		{
			Thread.sleep(4000);
			
			process.destroy();						
			System.out.println("Stopped Appium Server");
			
			
		}
		
	}

}

	
