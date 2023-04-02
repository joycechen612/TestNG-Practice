package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import PageLocators.LoginPageLocator;

public class LoginPage{

	private WebDriver driver;
	
	//private static final String url="https://boratech-practice-app.onrender.com";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	private WebElement loginButton;
	@FindBy(how = How.NAME, using = "email")
	private WebElement userNameField;
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;
	@FindBy(how = How.CSS, using = "input.btn.btn-primary")
	private WebElement submitButton;

	// Actions
	
	public void openURL() {
		driver.get("https://boratech-practice-app.onrender.com/login");
	}

	public void login(String email, String password) {
		//loginButton.click();
		userNameField.sendKeys(email);
		passwordField.sendKeys(password);
		submitButton.click();
	}

}
