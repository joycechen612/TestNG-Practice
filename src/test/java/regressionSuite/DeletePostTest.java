package regressionSuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ByPages.ByPostPage;
import testComponents.IRetry;

public class DeletePostTest extends BaseTest {
	
	@Test(retryAnalyzer= IRetry.class)
	public void deletePost() throws InterruptedException {
		assertTrue(byDashBoardPage.verifyLoadToDashBoardPage());
		ByPostPage byPostPage = byDashBoardPage.clickPostButton();
		byPostPage.deletedPostContent("This is Joyce from testNG -2");
	}
}
