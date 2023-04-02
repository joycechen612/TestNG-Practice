package PageLocators;

import org.openqa.selenium.By;

public class PostPageLocator {

	public static final By postTextField = By.tagName("textarea");

	public static final By submitButton = By.cssSelector("input[type='submit']");
	
	public static final By myPostContainer =By.xpath("//button[@class='btn btn-danger']/ancestor::div[@class='post bg-white p-1 my-1']");
	
	public static final By postContainer=By.xpath("//div[@class='post bg-white p-1 my-1']");
	
	public static final By myPostContent=By.xpath("//p[@class='my-1']");
	
	public static final By deletedButton= By.xpath("//button[@class='btn btn-danger']");

}
