package com.wbl.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.wbl.helper.ByClass;


public class HomePage {
    WebDriver driver;
    
    public HomePage(WebDriver driver){
    	this.driver=driver;
    }
    

    public int headerNavLink(){
    	List<WebElement> elements=driver.findElements(ByClass.getobject("css-navLocator"));
     return elements.size();  
    }

    public String searchBox(){
  driver.findElement(ByClass.getobject("id-searchLocator")).sendKeys("laptop");
		  	
		 WebDriverWait wait=new WebDriverWait(driver,20);
		String result= wait.until(function);
		return result;
    }
    
    Function<WebDriver,String> function =new Function<WebDriver,String>(){

		public String apply(WebDriver arg0) {
			WebDriverWait wait=new WebDriverWait(driver,30);
			List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ByClass.getobject("css-autosearchLocator")));
			//List<WebElement> elements =driver.findElements(By.cssSelector(autoSearchLocator));
			for (WebElement elm:elements){
				if (elm.getText().equalsIgnoreCase("laptops on sale"))
				{
					elm.click();
					break;
				}
			}
			return driver.getTitle();
		}
		
	};

	
    
	public SignInPage clickSignIn(){
		WebElement elm=driver.findElement(ByClass.getobject("xpath-myAccountLocator"));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getobject("linkText-signInLocator")));
		elm.click();
		return new SignInPage(driver);
	}
    
	public RegisterPage clickCreateAccount(){
		WebElement elm=driver.findElement(ByClass.getobject("xpath-myAccountLocator"));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getobject("xpath-createMyAccount")));
		elm.click();
		return new RegisterPage(driver);
	}
}
