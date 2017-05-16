package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ByClass {
	
	
	static Properties prop;
	
	public static void loadProperties() throws FileNotFoundException, IOException{
		
		prop = ConfigUtils.loadProperties("\\HomepageLocators.properties");

	}

	public static By getobject(String key){
		By by=null;
		
		if(key.startsWith("css")){
			return By.cssSelector(prop.getProperty(key));
			}else if(key.startsWith("xpath")){
				return By.xpath(prop.getProperty(key));
				
			}else if(key.startsWith("linkText")){
				return By.linkText(prop.getProperty(key));
			}else if(key.startsWith("id")){
				return By.id(prop.getProperty(key));
			}else if(key.startsWith("name")){
				return By.name(prop.getProperty(key));
			}	
		
		 
		return by;		
		
		
	}
}
