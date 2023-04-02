package regressionSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ByPages.ByDashBoardPage;
import ByPages.ByExperiencePage;
import ByPages.ByLoginPage;
import Pages.AddEducationPage;
import Pages.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	ByLoginPage byLoginPage;
	ByDashBoardPage byDashBoardPage;
	AddEducationPage educationPage;
	DashboardPage dashboard;
	ByExperiencePage byExperiencePage;

	@BeforeMethod
	public void Login() {
		try {
			startTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byLoginPage = new ByLoginPage(driver);
		byLoginPage.navigate();
		byDashBoardPage = byLoginPage.login("joycechen@test.com", "123456");
	}

	public void startTest() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/utilities/GlobalData.properities");
		prop.load(fis);
		String browswerName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browswerName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions Option = new ChromeOptions();
			Option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(Option);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browswerName.equalsIgnoreCase("firefox")) {
			// Firefox
		} else if (browswerName.equalsIgnoreCase("edge")) {
			// Edge
		}
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
	}

}
