package ByPages;

import org.openqa.selenium.WebDriver;
import PageLocators.DashBoardPageLocator;
import PageLocators.LoginPageLocator;

public class ByLoginPage extends BasePage {

	public WebDriver driver;
	private String expectedPageTitle = "Dashboard";

	public ByLoginPage(WebDriver passedDriver) {
		super(passedDriver);
		this.driver = passedDriver;
	}

	// actions
	public void navigate() {
		driver.get("https://boratech-practice-app.onrender.com/login");
	}

	public ByDashBoardPage login(String username, String password) {
		// click(LoginPageLocator.loginButton);
		enterText(LoginPageLocator.userNameField, username);
		enterText(LoginPageLocator.passwordField, password);
		click(LoginPageLocator.submitButton);
		return new ByDashBoardPage(driver);
	}

	public boolean verifyLoadToDashBoardPage() {
		dynamicWait(DashBoardPageLocator.pageTitle);
		return getText(DashBoardPageLocator.pageTitle).equals(expectedPageTitle);
	}

}
