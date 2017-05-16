package com.wbl.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.RegisterPage;

public class RegisterPageTest extends BaseTest{

	RegisterPage rp;
	HomePage hm;
	@ BeforeClass
	public void beforeclass(){
	        hm=new HomePage(driver);
	         rp= hm.clickCreateAccount();
}
	
	@Test
	public void testregister(){
		Assert.assertNotNull(rp.Register("Vani", "Kowta","sriprakki@gmail.com", "2222"));
	}
}
