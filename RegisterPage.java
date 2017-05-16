	package com.wbl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	  WebDriver driver;
	  public RegisterPage(WebDriver driver){
		  	this.driver=driver;
		  }
		  
		public String Register(String firstname,String lastname,String email,String passwd){
			String result=null;
			
			List<WebElement> elements=driver.findElements(By.cssSelector(".form-control"));
			elements.get(0).sendKeys(firstname);
			elements.get(1).sendKeys(lastname);
			elements.get(2).sendKeys(email);
			elements.get(3).sendKeys(passwd);
		    driver.findElement(By.xpath(".//button[text()='Create Account']")).click();
		  result =driver.getTitle();
		  return result;
		}
}
