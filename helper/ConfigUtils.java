package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
	 static Properties prop;
	
	public static Properties loadProperties(String fileName) throws FileNotFoundException, IOException{
		
		Properties prop = new Properties();
		try{
		prop.load(new FileInputStream(Constant.PATH + fileName));
		}catch(IOException e){
			e.printStackTrace();
		}
		
			return prop;
		}
	
}
