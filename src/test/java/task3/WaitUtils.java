package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
	public static void waitTillElementBeVisible(WebDriver driver, Duration timeSecond , By by) {
		WebDriverWait wait = new WebDriverWait(driver,timeSecond);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitTillAlertPresent(WebDriver driver, Duration timeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver ,timeSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitTillElementToBeClickable(WebDriver driver, Duration timeSeconds, By by) {
		WebDriverWait wait = new WebDriverWait(driver ,timeSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitTillElementBeInVisible(WebDriver driver, Duration timeSecond , By by) {
		WebDriverWait wait = new WebDriverWait(driver,timeSecond);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void waitTillElementBeVisibleUsingFluentWait(WebDriver driver,int pollingTime,
													   int timeSecond , By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeSecond))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
