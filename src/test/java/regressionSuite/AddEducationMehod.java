package regressionSuite;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.AddEducationPage;
import Pages.DashboardPage;

public class AddEducationMehod extends BaseTest {

	@Test(dataProvider="educationDriverTest")
	public void addEducation(String school, String Degree, String study, String from, String current, String to,
			String description) {
		dashboard = new DashboardPage(driver);
		educationPage = new AddEducationPage(driver);
		dashboard.navigateToAddEducationPage();
		educationPage.fillInEducationInfo(school, Degree, study, from, current, to, description);
	}

	@DataProvider(name = "educationDriverTest")
	public Object[][] getData() throws IOException {
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream("/Users/shaopingchen/Downloads/educationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNumber = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getLastCellNum();
		// Object[][] data = new Object[4-1][7]
		Object[][] data = new Object[rowNumber - 1][column];
		for (int i = 0; i < rowNumber - 1; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < column; j++) {
			//	data[i][j]=row.getCell(j);
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
	}
}








