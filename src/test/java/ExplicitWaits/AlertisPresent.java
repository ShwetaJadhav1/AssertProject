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

public class AlertisPresent {
	

	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://omayo.blogspot.com/");

//		WebElement ele=driver.findElement(By.xpath("//input[@id='alert1']"));
//		ele.click();
//		
//		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	     wait.until(ExpectedConditions.alertIsPresent());
//		
//		Alert alert=driver.switchTo().alert();
//		
//		alert.accept();
		
		 By ele1=By.xpath("//input[@id='alert1']");
		 waitForAlert(driver,ele1,10).click();
	}


	 public static WebElement waitForAlert(WebDriver driver,By locator,int timeout)
	 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	     wait.until(ExpectedConditions.alertIsPresent());
	     
//	     Alert alert = driver.switchTo().alert();
//	     alert.accept();
//	     
	     return driver.findElement(locator);
	 }
}

