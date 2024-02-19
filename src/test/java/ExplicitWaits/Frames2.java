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

public class Frames2 {
	WebDriver driver;


	@Test
	public void test() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        
       driver.get("https://demo.automationtesting.in/Frames.html");
		
      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        
      try {
            // Switch to frame by its index
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
            WebElement frameBody = driver.findElement(By.xpath("//input[@type='text']"));
            frameBody.sendKeys("Text entered inside frame");

            // Switch back to default content
            driver.switchTo().defaultContent();

            // Print success message
            System.out.println("Text entered successfully inside the frame.");
        } catch (Exception e) {
            // Print error message
            System.out.println("Failed to enter text inside the frame: " + e.getMessage());
        } finally {
	}
	}
}


