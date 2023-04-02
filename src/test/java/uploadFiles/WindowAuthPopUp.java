/*Hadling Window Authentication Pop Up
 * http://Username:Password@SiteURL
 * demo website: http://the-internet.herokuapp.com
 */
package uploadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAuthPopUp {
	
	@Test
	public void testAuth() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Option = new ChromeOptions();
		Option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://admin:admin@the-internet.herokuapp.com");
		driver.findElement(By.linkText("Basic Auth")).click();
		
	}
}
