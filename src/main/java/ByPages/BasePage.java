package ByPages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver passedDriver) {
		driver = passedDriver;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public void click(By locator) {
		driver.findElement(locator).click();

	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void enterText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void dynamicWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void explictlyWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void explictlyWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

}
