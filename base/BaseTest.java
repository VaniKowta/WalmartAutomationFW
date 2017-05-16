package com.wbl.base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.wbl.helper.ByClass;
import com.wbl.helper.WebUIDriver;

public class BaseTest {
   protected WebDriver driver;
   
	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException{
	
		
		try {
			
			WebUIDriver.loadProperties("config.properties");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		driver = WebUIDriver.getDriver();
	//	driver.get("https://www.walmart.com");
		driver.get(WebUIDriver.appUrl);
		ByClass.loadProperties();

	}
	
	@AfterTest
	public void afterTest(){
		driver.close();
	}
}

/*public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws IOException, Exception {
		ByClass.loadProperties();
		ConfigUtils.loadProperties("config.properties");
		driver=WebUIDriver.getDriver(ConfigUtils.getValue("browser"));
		driver.get(ConfigUtils.getValue("url"));
	}
	
	

	
}*/
