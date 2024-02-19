package synchronization1;

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

public class ExplicitWait {

	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://sellglobal.ebay.in/seller-center/");

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("START SELLING")));
		element.click();
		
		WebElement element1= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("START SELLING")));
		element1.click();
		
	}	
	}













    

