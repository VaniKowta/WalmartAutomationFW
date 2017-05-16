package com.wbl.helper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	@SuppressWarnings("unchecked")
	public static  <V> WebElement explicitWaitforSingleElement(WebDriver driver,long timeInSecs,String key){
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		return (WebElement) wait.until((Function<? super WebDriver, V>) ExpectedConditions.visibilityOfElementLocated(ByClass.getobject(key)));
		
		
	}
	
	public static void implicitWait(WebDriver driver, long timeInSecs){
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
