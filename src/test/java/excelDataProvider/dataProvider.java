package excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@Test(dataProvider = "driverTest")
	public void testCaseData(String greeting, String communication, String id) {
		System.out.println(greeting + communication + id);
	}

	@DataProvider(name = "driverTest")
	public Object[][] getData() throws IOException {

		DataFormatter formatter= new DataFormatter();
		FileInputStream fis = new FileInputStream("/Users/shaopingchen/Downloads/dataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int column = row.getLastCellNum();
		Object[][] data= new Object[rowCount-1][column];
		for(int i=0;i<rowCount-1;i++) {
			row = sheet.getRow(i+1);
			for(int j=0;j<column;j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
			}
		}
		return data;

	}

}
