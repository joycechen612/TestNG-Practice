package PageLocators;

import org.openqa.selenium.By;

public class LoginPageLocator {

	public static final By loginButton = By.xpath("//a[text()='Login']");
	public static final By userNameField = By.name("email");
	public static final By passwordField = By.name("password");
	public static final By submitButton = By.cssSelector("input.btn.btn-primary");

}
