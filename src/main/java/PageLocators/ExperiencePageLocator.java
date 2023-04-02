package PageLocators;

import org.openqa.selenium.By;

public class ExperiencePageLocator {

	public static final By jobTitle = By.name("title");
	public static final By company = By.name("company");
	public static final By location = By.name("location");
	public static final By from = By.name("from");
	public static final By checkBox = By.name("current");
	public static final By to = By.name("to");
	public static final By description = By.tagName("textarea");
	public static final By submitButton = By.xpath("//input[@type='submit']");
	public static final By latestComapanyText =By.xpath("(//table[1]/tbody//td[1])[1]");

}
