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

public class Frame {

	WebDriver driver;

	@Test
	public void Script() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Frames.html"); 

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='SingleFrame']")); 

		// Call the method to check if the frame is available and switch to it
		boolean frameAvailable = isFrameToBeAvailableAndSwitchToIt(driver, frameElement, 10); 

		if (frameAvailable) {

			System.out.println("Frame is available and switched to. Perform actions within the frame.");

			// Find an element inside the frame and interact with it
			WebElement elementInsideFrame = driver.findElement(By.xpath("//input[@type='text']")); 
			elementInsideFrame.sendKeys("Text entered inside frame"); 
		} else {
			// If the frame is not available within the specified timeout
			System.out.println("Frame is not available within the specified timeout.");
		}

		// Close the WebDriver session
		driver.quit();
	}

	public static boolean isFrameToBeAvailableAndSwitchToIt(WebDriver driver, WebElement frameElement, int explicitWait) {

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
			return true; 
		} catch (Exception e) {
			return false; 
		}
		}
}
