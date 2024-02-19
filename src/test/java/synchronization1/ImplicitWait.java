package synchronization1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://sellglobal.ebay.in/seller-center/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.linkText("START SELLING")).click();

		Actions a =new Actions(driver);

		WebElement ele=	driver.findElement(By.xpath("//ul[@id='menu-header-1']//a[@class='ekit-menu-nav-link'][normalize-space()='Performance']"));

		a.moveToElement(ele).perform();
	}
}








