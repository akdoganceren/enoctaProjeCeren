package Enocta;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ProductProcess extends BaseClass {

	
	public static WebElement findLowestRatedSeller(List<WebElement> buttons) {
		
        WebElement smallestButton = null;
        
        double smallestNumber = Double.MAX_VALUE;

        for (WebElement button : buttons) {
            try {
                double number = Double.parseDouble(button.getText().trim());
                if (number < smallestNumber) {
                    smallestNumber = number;
                    smallestButton = button;
                }
            } catch (NumberFormatException e) {
             
                continue;
            }
        }

        return smallestButton;
    }

	public static void addBasketLowPointSeller() {
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		CommonFunctions.waitTime();
		WebElement showAllSellers = driver.findElement(By.xpath("//a[@class='show-all']"));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", showAllSellers);

		showAllSellers.click();
		CommonFunctions.waitTime();
	        
	        
	    List<WebElement> allSellerElements = driver.findElements(By.xpath("//div[@class='sl-pn']"));

	    // Find  the smallest number value
	    
	    WebElement smallestNumberButton = findLowestRatedSeller(allSellerElements);

	    if (smallestNumberButton != null) {
	    	    CommonFunctions.waitTime();
	            smallestNumberButton.click();
	            CommonFunctions.waitTime();
	            System.out.println("The seller with the smallest numerical value was clicked.");
	       } else {
	            System.out.println("Button not found.");
	            BasketPage.addBasket();
	            System.out.println("The button on the page with the smallest number value was clicked.");
	       }
	    CommonFunctions.waitTime();
	}

}
