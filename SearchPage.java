package com.wbl.page;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	public SearchPage(WebDriver driver){

		this.driver = driver;
	}
	WebDriver driver;

	public boolean searchPageVerifyTitle(){
		List<WebElement> results =	driver.findElements(By.xpath(".//a[contains(@class,'product-title-link')]"));
		for(WebElement element:results){
			String resultTitle=element.getAttribute("aria-label");
			if(!resultTitle.toLowerCase().contains("laptop")){

				return false;
			}
		}
		return true;

	}

	public String sortResults(){

		driver.findElement(By.cssSelector(".chooser-option-current")).click();
		driver.findElement(By.xpath(".//div[@data-automation-id='select-option-4']")).click();
		WebDriverWait  wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chooser-option-current")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@data-automation-id='select-option-4']")));
		List<WebElement> results =	driver.findElements(By.xpath(".//a[contains(@class,'product-title-link')]"));
		results.get(0).click();
		return driver.getTitle();
	}

}
