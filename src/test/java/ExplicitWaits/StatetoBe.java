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

public class StatetoBe {

	WebDriver driver;

	@Test
	public void Script() {
		boolean value;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/checkboxes");

		// Find the check box element
		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));

		// Check if the check box is selected
		if (!checkbox.isSelected()) {
			// If not selected, click on it
			checkbox.click();
		}

		// Wait until the check box is selected
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		value=wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, false));
        System.out.println(value);
		// Perform actions after the check box is selected
		System.out.println("Checkbox is selected.");
	}	
	}


