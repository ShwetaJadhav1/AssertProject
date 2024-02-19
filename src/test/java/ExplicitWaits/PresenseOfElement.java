package ExplicitWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PresenseOfElement {
	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

       driver.get("http://demo.guru99.com/test/ajax.html");
   
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("yes")));
    element.click();
	
	}
	
	@Test
    public void testElementPresence() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       
        driver.get("http://demo.guru99.com/test/ajax.html");

        By ele = By.id("yes");
        waitForElementPresence(driver, ele, Duration.ofSeconds(10)).click();
    }

    public WebElement waitForElementPresence(WebDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
	
