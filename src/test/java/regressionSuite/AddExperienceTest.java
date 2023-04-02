package regressionSuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import testComponents.IRetry;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;


public class AddExperienceTest extends BaseTest {

//	@Test(dataProvider="experieceInfoDriven")
//	public void addExperience(String jobTitle, String company, String location, String from, String current,
//			String to, String description) {
//		byExperiencePage = byDashBoardPage.clickAddExperienceButton();
//		byExperiencePage.enterExperienceInfo(jobTitle,company,location,from,current,to,description);
//		//AssertJUnit.assertTrue(byExperiencePage.verifyIfAdd(company));
//
//	}
	@Test(retryAnalyzer=IRetry.class)
	public void addExperience() {
		byExperiencePage = byDashBoardPage.clickAddExperienceButton();
		byExperiencePage.enterExperienceInfo("BORA","bORA","va","03/12/2021","true","04/12/2022","nice");
		//assertTrue(byExperiencePage.verifyIfAdd("bORAa"));

	}

//	@DataProvider(name = "experieceInfoDriven")
//	public Object[][] getData() throws IOException {
//		DataFormatter formatter = new DataFormatter();
//		FileInputStream input = new FileInputStream("/Users/shaopingchen/Downloads/experieceInfo.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(input);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		int rowNum = sheet.getPhysicalNumberOfRows();
//		int column = sheet.getRow(0).getLastCellNum();
//		Object[][] data = new Object[rowNum - 1][column];
//		for (int i = 0; i < rowNum - 1; i++) {
//			XSSFRow row = sheet.getRow(i + 1);
//			for (int j = 0; j < column; j++) {
//				data[i][j] = formatter.formatCellValue(row.getCell(j));
//				//data[i][j] = formatter.formatCellValue(cell);
//			}
//		}
//
//		return data;
//	}

}
