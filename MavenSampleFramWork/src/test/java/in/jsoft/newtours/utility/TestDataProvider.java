package in.jsoft.newtours.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	static FileInputStream ft = null;
	static Workbook w = null;
	static Sheet s = null;
	static final String EXCEL_FILEPATH= "./TestData/POINewToursTestData.xls";

	@Test(dataProvider = "NewTours", dataProviderClass = TestDataProvider.class)
	public void verifyRegistrationPage(String... f1) throws IOException, InterruptedException {
		for (String l : f1) {
			System.out.print(l + "\t");
		}

		System.out.println();

	}

	// DataProvider
	@DataProvider(name = "NewTours") // (1)
	public static String[][] getTestData(Method m) // (string tetcasename) (2)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		// String st = testcasename; //(3)
		ft = new FileInputStream(TestDataProvider.EXCEL_FILEPATH);
		
//		System.out.println(ft);
		w = WorkbookFactory.create(ft);
		s = w.getSheet("Sheet1");

		String st = m.getName();

		int rowCount = s.getPhysicalNumberOfRows();
		System.out.println(rowCount);

		String[][] testData = new String[getRowCount(st)][getColCount(st)+1];

		System.out.println("total row : " + testData.length);
		System.out.println("total cell : " + testData[0].length);

		int resultRow = 0;
		int tp = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			//System.out.println("toatl column" + testData[tp].length);
			Row r = s.getRow(rowIndex);
			if (r.getCell(2).getStringCellValue().equalsIgnoreCase("Y")
					&& r.getCell(1).getStringCellValue().equalsIgnoreCase(st)) {

				int cellCount = r.getLastCellNum();
				// System.out.println(cellCount);

				int resultColumn = 0;
				for (int colIndex = 3; colIndex < cellCount; colIndex++) {
					Cell c = r.getCell(colIndex);

					testData[resultRow][resultColumn++] = c.getStringCellValue();
					testData[resultRow][resultColumn] = rowIndex+"";
					//System.out.print("Test Data : " + resultRow + " col : " + (resultColumn - 1) + " "
							//+ testData[resultRow][resultColumn - 1]);
				}
				resultRow++;
				//System.out.println();
			}

		}
		// System.out.println(testData.toString());
		return testData;

	}

	// To get the row count for a given testcase name and run status is y.
	public static int getRowCount(String st) throws EncryptedDocumentException, InvalidFormatException, IOException {

		int rowCount = s.getPhysicalNumberOfRows();
		int count = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s.getRow(rowIndex);
			Cell c1 = r.getCell(2);
			Cell c2 = r.getCell(1);
			String cellData1 = c1.getStringCellValue();

			if (cellData1.equalsIgnoreCase("Y") && c2.getStringCellValue().equalsIgnoreCase(st)) {
				count++;
			}

		}
		return count;
	}

	// To get the column count for a given testcase name and only when the run
	// status is y.
	public static int getColCount(String st) throws EncryptedDocumentException, InvalidFormatException, IOException {

		int rowCount = s.getPhysicalNumberOfRows();

		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s.getRow(rowIndex);
			Cell c1 = r.getCell(2);
			Cell c2 = r.getCell(1);
			String cellData1 = c1.getStringCellValue();

			if (cellData1.equalsIgnoreCase("Y") && c2.getStringCellValue().equalsIgnoreCase(st)) {
				return (r.getLastCellNum() - 3);

			}

		}
		return 0;
	}
	
	public static void writeExcel(String data, int rowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
//		FileInputStream ft = new FileInputStream("./TestDataFolder/POINewToursTestData.xls");
//		Workbook w = WorkbookFactory.create(ft);
//		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNum);
		
		Cell c = r.createCell(cellNum);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(TestDataProvider.EXCEL_FILEPATH);
		w.write(fos);
		fos.close();
		
		System.out.println("writing completed");
	}

}
