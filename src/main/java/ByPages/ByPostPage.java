package ByPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageLocators.PostPageLocator;

public class ByPostPage extends BasePage {

	private WebDriver driver;
	

	// constructor
	public ByPostPage(WebDriver passedDriver) {
		super(passedDriver);
		driver = passedDriver;
	}

	// actions
	public void enterPostContent(String content) {
		enterText(PostPageLocator.postTextField, content);
		click(PostPageLocator.submitButton);
	}

	public boolean validatePostAdd(String expectedPostCotent) {
		List<WebElement> postContains = driver.findElements(PostPageLocator.myPostContainer);
		boolean found = false;
		for (WebElement mypost : postContains) {
			String actualContent = mypost.findElement(By.tagName("p")).getText();
			if (actualContent.contains(expectedPostCotent)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public void deletedPostContent(String expectedPostCotent) throws InterruptedException {
		List<WebElement> myPosts = driver.findElements(PostPageLocator.myPostContainer);
		for (WebElement myPost : myPosts) {
			if (myPost.findElement(PostPageLocator.myPostContent).getText().equals(expectedPostCotent)) {
				myPost.findElement(PostPageLocator.deletedButton).click();
			}
			break;
		}
		Thread.sleep(3000);

	}

}
