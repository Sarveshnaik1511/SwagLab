package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public String getData(String sheet, int row, int column) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Software Testing Arise\\SwagLab\\src\\test\\resources\\TestData.xlsx");

		String value = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return value;
	}
}
