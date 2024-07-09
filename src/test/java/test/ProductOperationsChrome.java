
package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Enocta.BaseClass;
import Enocta.BasketPage;
import Enocta.OpenPage;
import Enocta.ProductProcess;
import Enocta.ProductSelectRandomProcess;


public class ProductOperationsChrome extends BaseClass  {

	    
	 @BeforeClass
		public void beforeClass() {
		 super.beforeClass("chrome");
	    }  
	    
	@Test(priority =1)
	    public void openPageTest() {
		driver.get("https://www.trendyol.com/");
	    }
	
	@Test(priority =2)
    public void userLoginTest() {
	OpenPage.userLogin();
    }
	
	@Test(priority =3)
		public void searchTest() {
		ProductSelectRandomProcess.search();
    }
	
	@Test(priority =4)
		public void filtrePriceTest() {
		ProductSelectRandomProcess.filterPrice();
}
	
	@Test(priority =5)
		public void randomProductSelectTest() {
		ProductSelectRandomProcess.randomProductSelect();
	}
		
	@Test(priority =6)
		public void addBasketLowPointSellerTest() {
		ProductProcess.addBasketLowPointSeller();
	}
	
	@Test(priority =7)
		public void addBasketControlTest(){
		BasketPage.addBasket();
	}
	
	@Test(priority =8)
	public void deleteBasketTest(){
	BasketPage.deleteBasket();
}
		    
	    
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		super.afterClass();
	}
}
