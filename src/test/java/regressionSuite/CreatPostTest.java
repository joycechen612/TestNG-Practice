package regressionSuite;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import ByPages.ByPostPage;

public class CreatPostTest extends BaseTest {
	private String postContent="This is Joyce from testNG -2";
	@Test()
	public void CreatePost() {
		
		AssertJUnit.assertTrue(byDashBoardPage.verifyLoadToDashBoardPage());
		ByPostPage byPostPage = byDashBoardPage.clickPostButton();
		byPostPage.enterPostContent(postContent);
		byPostPage.validatePostAdd(postContent);
	}
}
