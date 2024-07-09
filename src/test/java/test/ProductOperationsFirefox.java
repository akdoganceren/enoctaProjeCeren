package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Enocta.BaseClass;
import Enocta.OpenPage;

public class ProductOperationsFirefox extends BaseClass {

	@BeforeClass
	public void beforeClass() {
		super.beforeClass("firefox");
	}

	@Test(priority =1)
    public void openPageTest() {
	driver.get("https://www.trendyol.com/");
	OpenPage.userLogin();
    }

}
