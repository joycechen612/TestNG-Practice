package ByPages;

import org.openqa.selenium.WebDriver;

import PageLocators.ExperiencePageLocator;

public class ByExperiencePage extends BasePage {

	public WebDriver driver;

	// constructor
	public ByExperiencePage(WebDriver passedDriver) {
		super(passedDriver);
		driver = passedDriver;
	}

	// actions
	public void enterExperienceInfo(String jobTitle, String company, String location, String from, String current,
			String to, String description) {
		enterText(ExperiencePageLocator.jobTitle, jobTitle);
		enterText(ExperiencePageLocator.company,company);
		enterText(ExperiencePageLocator.location,location);
		enterText(ExperiencePageLocator.from,from);
		if(current.equalsIgnoreCase("true")) {
			click(ExperiencePageLocator.checkBox);
		}else {
			enterText(ExperiencePageLocator.to,to);
		}
		enterText(ExperiencePageLocator.description,description);
		click(ExperiencePageLocator.submitButton);
	}
	
	public boolean verifyIfAdd(String company) {
		return getText(ExperiencePageLocator.latestComapanyText).equals(company);
	}

}
