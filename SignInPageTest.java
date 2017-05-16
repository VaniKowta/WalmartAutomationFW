package com.wbl.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.helper.Constant;
import com.wbl.helper.ExcelHelper;
import com.wbl.page.HomePage;
import com.wbl.page.SignInPage;

public class SignInPageTest extends BaseTest {

	SignInPage sp;
	HomePage hm;
	
	@ BeforeClass
	public void beforeclass(){
          hm=new HomePage(driver);
          //using homepage signin method to navigate to signin
          sp=hm.clickSignIn();
}
	
	@DataProvider(name="logindata")
	public Object[][] testdata(){
		Object[][] data=ExcelHelper.getdata(Constant.PATH+"/testdata/loginData.xlsx");
		return data;
	}
	@Test(dataProvider="logindata")
	public void testlogin(String username,String passwd){
		Assert.assertNotNull(sp.SignIn(username,passwd));
	}
}
