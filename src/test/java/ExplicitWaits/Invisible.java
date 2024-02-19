package ExplicitWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Invisible {

	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[normalize-space()='Dynamic Loading']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Example 1: Element on page that is hidden']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		String ele=  driver.findElement(By.xpath("//h4[normalize-space()='Hello World!']")).getText();
		System.out.println(ele);

	}
}