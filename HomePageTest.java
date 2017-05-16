
package com.wbl.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.helper.ExcelHelper;
import com.wbl.page.HomePage;


public class HomePageTest extends BaseTest {
	
	HomePage hm;
	static Logger log = LogManager.getLogger(ExcelHelper.class);
	@ BeforeClass
	public void beforeclass(){
      hm=new HomePage(driver);

}
	
	@Test(priority=0)
	public void testHeaderNav(){
		Assert.assertEquals(14,hm.headerNavLink());
		
	}
	
	
	@Test
	public void testSearchbox(){
		//System.out.println(hm.searchBox());
		Assert.assertEquals("laptops on sale - Walmart.com",hm.searchBox());
	}
	
}



