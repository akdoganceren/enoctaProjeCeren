package Enocta;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class ProductSelectRandomProcess extends BaseClass {

	// Product Search 

	public static void search() {
		
		CommonFunctions.waitTime();
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']"));

		searchButton.clear();
		
		searchButton.sendKeys("cep telefonu");
		
		CommonFunctions.waitTime();

		searchButton.sendKeys(Keys.ENTER);
		
		CommonFunctions.waitTime();

		System.out.println("Products containing mobile phones were listed.");

	}

	public static void filterPrice() {

		WebElement filterButton = driver.findElement(By.xpath("//div[text()='Fiyat']"));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", filterButton);

		try {
			WebElement scrollButton = driver.findElement(By.xpath("//div[@class='overlay']"));
			scrollButton.click();
		} catch (Exception e) {
			// TODO: handle exception
		
		}
		
		filterButton.click();

		WebElement minPrice = driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input min']"));
		minPrice.sendKeys("15000");

		WebElement maxPrice = driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input max']"));
		maxPrice.sendKeys("20000");

		WebElement searchPrice = driver.findElement(By.xpath("//button[@class='fltr-srch-prc-rng-srch']"));
		searchPrice.click();

		CommonFunctions.waitTime();
		
		System.out.println("Price Filter Successful");


	}
	

	//Selecting a random product from the page that opens as a result of the search

	public static void randomProductSelect() {

		CommonFunctions.waitTime();


		List<WebElement> allElements =
				driver.findElements(By.xpath("//span[@class='prdct-desc-cntnr-name hasRatings']"));


		System.out.println("Toplam element sayısı: "+allElements.size());

		List<WebElement> subList = allElements.subList(allElements.size()-4, allElements.size());
		
		Random objGenerator = new Random();
		int randomProduct = objGenerator.nextInt(subList.size());
		System.out.println("Random select product number : " + randomProduct);
		WebElement productSelect = subList.get(randomProduct);
		
		CommonFunctions.waitTime();
		
		System.out.println("Selected product name:" + productSelect.getText());

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", productSelect);

		CommonFunctions.waitTime();

		productSelect.click();
		
		System.out.println("Product selected");

		CommonFunctions.waitTime();

		
	}
}

	