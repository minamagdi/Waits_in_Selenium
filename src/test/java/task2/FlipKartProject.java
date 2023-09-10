package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FlipKartProject {
	ChromeDriver driver;
	String url = "https://flipkart.com/";

	@BeforeClass
	public void invokeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}

	@Test
	public void verifyTitle() {
		Actions action = new Actions(driver);
		driver.findElement(By.cssSelector("span[role='button']")).click();
		WebElement electronic = driver.findElement(By.xpath("//span[text()='Electronics']"));
		action.moveToElement(electronic).build().perform();
		WebElement gsd = driver.findElement(By.xpath("//a[text()='Audio']"));
		action.moveToElement(gsd).click(gsd).build().perform();
	}

	@AfterClass
	public void tearsDown() {
		driver.quit();
	}
}
