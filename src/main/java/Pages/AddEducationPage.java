package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import PageLocators.EducationPageLocator;

public class AddEducationPage {
	private WebDriver driver;
	
	public AddEducationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.NAME, using = "school")
	WebElement schoolField;

	@FindBy(how = How.NAME, using = "degree")
	WebElement degreeField;

	@FindBy(how = How.NAME, using = "fieldofstudy")
	WebElement fieldOfStudyField;

	@FindBy(how = How.NAME, using = "from")
	WebElement fromDate;

	@FindBy(how = How.NAME, using = "current")
	WebElement currentDateCheckBox;

	@FindBy(how = How.NAME, using = "to")
	WebElement toDate;

	@FindBy(how = How.TAG_NAME, using = "textarea")
	WebElement descriptionField;

	@FindBy(how = How.CLASS_NAME, using = "btn-primary")
	WebElement submitButton;



	public void fillInEducationInfo(String school,String Degree,String study,String from,String current,String to,String description) {
		schoolField.sendKeys(school);
		degreeField.sendKeys(Degree);
		fieldOfStudyField.sendKeys(study);
		fromDate.sendKeys(from);
	
		if(current.equalsIgnoreCase("true")) {
			currentDateCheckBox.click();
		}else {
			toDate.sendKeys(to);
		}
		descriptionField.sendKeys(description);
		submitButton.click();
	}

}
