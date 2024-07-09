package Enocta;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class BasketPage extends BaseClass {
	
	public static void addBasket() {
		
		CommonFunctions.waitTime();
		WebElement productName = driver.findElement(By.xpath("//h1[@class='pr-new-br']"));
		System.out.println("Added Product"+ productName.getText());
	
		WebElement addBAsketButton = driver.findElement(By.xpath("//button[@component-id='1']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250);", addBAsketButton);
		addBAsketButton.click();
		CommonFunctions.waitTime();
		
		goBasket();

		WebElement productNameBasket = driver.findElement(By.xpath("//p[@class='pb-item']"));
		System.out.println("Added Product"+ productNameBasket.getText());
		
		CommonFunctions.waitTime();
        Assert.assertEquals(productName.getText(), productNameBasket.getText(), "The product added to the basket is correct");

	}
	
	public static void goBasket() {
		
		CommonFunctions.waitTime();
		
		try {
			WebElement goBasketButton = driver.findElement(By.xpath("//a[@class='go-basket-button']"));
			goBasketButton.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		CommonFunctions.waitTime();
		System.out.println("The basket is opened.");
		new Actions(driver).sendKeys(Keys.F5).build().perform();

	}
	
	
	public static void deleteBasket() {

		CommonFunctions.waitTime();
		WebElement overlay = driver.findElement(By.xpath("//div[@class='onboarding-overlay']"));
		overlay.click();
		
		try {
            WebElement deleteButton = driver.findElement(By.xpath("//i[@class='i-trash']"));
            
            deleteButton.click();
            System.out.println("The basket is cleaned.");
        } catch (NoSuchElementException e) {
            
            System.out.println("Element doesn't exist.");
        }
		
		CommonFunctions.waitTime();
		

	}
	
}
