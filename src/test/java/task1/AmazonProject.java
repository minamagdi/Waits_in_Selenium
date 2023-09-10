package task1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AmazonProject {
	ChromeDriver driver;
	String url = "https://www.amazon.com/";

	@BeforeClass
	public void invokeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
	}

	@Test
	public void verifyTitle() {
		String actualResult = driver.getTitle();
		String expectedResult = "Amazon.com. Spend less. Smile more.";

		assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void tearsDown() {
		//driver.quit();
	}
}
