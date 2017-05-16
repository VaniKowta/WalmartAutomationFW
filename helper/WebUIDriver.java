package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebUIDriver {
	public static String browserName; 
	public static String appUrl;
	
	public static void loadProperties(String fileName) throws FileNotFoundException, IOException{
		
     Properties prop= ConfigUtils.loadProperties(fileName);
    
     browserName =  prop.getProperty("browser");
    appUrl = prop.getProperty("url");
     		
	}
	
 public static WebDriver getDriver(){
	 
	 WebDriver driver=null;
	 
	 switch(browserName){
	 
	 case "Firefox":
		 System.setProperty("webdriver.gecko.driver",Constant.PATH+ "\\geckodriver.exe");
		  driver=new FirefoxDriver();
	 case "Chrome":	
		 System.setProperty("webdriver.chrome.driver",Constant.PATH+ "\\chromedriver.exe");
		  driver=new ChromeDriver();
	 case "default":
		 
		 System.setProperty("webdriver.chrome.driver",Constant.PATH+ "\\chromedriver.exe");
		  driver=new ChromeDriver();
	 }
	 return driver;
	 
 }

}
