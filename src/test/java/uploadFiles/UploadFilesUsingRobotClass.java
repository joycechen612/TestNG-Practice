package uploadFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFilesUsingRobotClass {

	@Test
	public void uploadFilesUsingRobotClass() throws AWTException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions Option = new ChromeOptions();
		Option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/upload");
		//# solution using sendKeys
//		driver.findElement(By.id("file-upload")).sendKeys("/Users/shaopingchen/Desktop/SQL.pdf");
//		driver.findElement(By.id("file-submit")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement upload = driver.findElement(By.xpath("//input[@name='file']"));
		js.executeScript("arguments[0].click()", upload);
		// use of Robot class to upload file
		Robot robot = new Robot();
		// store the path of the file to be uploaded using StringSelection class object
		StringSelection filePath = new StringSelection("/Users/shaopingchen/Desktop/SQL.pdf");
		// Copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		// Now press 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);

		// Release 
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);

		// Press ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
		System.out.println("File upload successfully by using Robot class");
		driver.quit();
		

	}

}
