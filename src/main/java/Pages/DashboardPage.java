package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import PageLocators.DashBoardPageLocator;

public class DashboardPage {

	// Local Variable
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Element
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Education']")
	private WebElement addEducationButton;
	

	// Actions

	public void navigateToAddEducationPage() {
		addEducationButton.click();
	}

}
