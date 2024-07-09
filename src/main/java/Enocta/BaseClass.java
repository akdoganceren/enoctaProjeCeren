package Enocta;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
    protected static WebDriver driver;

    
	@BeforeClass
	@Parameters("browser")
    public void beforeClass(String browser) {


                if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\90533\\eclipse-workspace\\EnoctaVakaCalismasi\\chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\90533\\eclipse-workspace\\EnoctaVakaCalismasi\\geckodriver.exe");
                    driver = new FirefoxDriver();
                } else {
                    throw new IllegalArgumentException("Browser not supported: " + browser);
                }
                driver.manage().window().maximize();

	}
        

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		  if (driver != null) {
	            driver.quit();
    	
		  }
	}
}