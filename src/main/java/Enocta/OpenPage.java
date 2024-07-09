package Enocta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpenPage extends BaseClass {

	CommonFunctions commonFunctions;


	
	//Logging in with user information

	public static void userLogin() {
		
		CommonFunctions.waitTime();

		try {
			WebElement cookieAccept = driver.findElement(By.id("onetrust-accept-btn-handler"));
			cookieAccept.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		WebElement mainmenu=driver.findElement(By.xpath("//div[@class='link account-user']"));
		mainmenu.click();

		WebElement mail = driver.findElement(By.id("login-email"));
		mail.sendKeys("****");

		CommonFunctions.waitTime();
		WebElement password = driver.findElement(By.id("login-password-input"));
		password.sendKeys("****");
		
		WebElement signInButton = driver.findElement(By.xpath("//div[@id='login-register']/div[3]/div[1]/form[1]/button[1]"));
		signInButton.click();



	}

}
