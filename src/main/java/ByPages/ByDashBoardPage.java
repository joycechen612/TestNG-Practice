package ByPages;

import org.openqa.selenium.WebDriver;

import PageLocators.DashBoardPageLocator;

public class ByDashBoardPage extends BasePage {
	
    //variable
	public WebDriver driver;
	private String expectedPageTitle = "Dashboard";
	
    //constructor
	public ByDashBoardPage(WebDriver passedDriver) {
		super(passedDriver);
		driver = passedDriver;
	}
    
	 //Actions
	public boolean verifyLoadToDashBoardPage() {
		return getText(DashBoardPageLocator.pageTitle).equals(expectedPageTitle);
	}
	
	public ByPostPage clickPostButton() {
		click(DashBoardPageLocator.postButton);
		return new ByPostPage(driver);
	}
	
	public ByExperiencePage clickAddExperienceButton() {
		click(DashBoardPageLocator.addExperienceButton);
		return new ByExperiencePage(driver);
		
	}
	
	
	

}
