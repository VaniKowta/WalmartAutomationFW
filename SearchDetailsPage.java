package com.wbl.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchDetailsPage {
	
	public SearchDetailsPage(WebDriver driver){
		
		this.driver = driver;
	}

	WebDriver driver;
	
	public String getDetailsTitle(){
		return driver.getTitle();
		
	}
	
	public String resulTitle(){
		
	WebElement element =driver.findElement(By.xpath("//*[@class='prod-ProductTitle no-margin heading-a']/div"));
	return element.getText();
		
	}
}
