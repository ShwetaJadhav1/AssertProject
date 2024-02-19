package synchronization1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waitfluent {

	WebDriver driver;

	//@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://sellglobal.ebay.in/seller-center/");

		Wait <WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("START SELLING")));
		element.click();

	}

	//Generic method
	@Test
	public void Script2() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://sellglobal.ebay.in/seller-center/");

		Wait <WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element= wait.until(new Function<WebDriver,WebElement>(){

			public WebElement apply(WebDriver driver)
			{
				return driver.findElement((By.linkText("START SELLING")));

			}
		});
		element.click();
}
}