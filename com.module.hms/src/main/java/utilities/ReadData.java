package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ReadData {
	
	public static XSSFSheet sh;
	public static WebDriver driver = null;
	
	//@DataProvider(name="hms")
	public static Object[][] excelData(Method name) {

			String sheetName = name.getName();
	
			File file = new File("./TestData/hms.xlsx");
			try {
				FileInputStream fin = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fin);
				sh = wb.getSheet(sheetName);
				wb.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			int rows = sh.getLastRowNum() - sh.getFirstRowNum();
			int cols = sh.getRow(0).getLastCellNum();

			Object[][] obj = new Object[rows][1];
			
			System.out.println("Total No.of Rows " + rows);
			System.out.println("Total No.of Columns " + cols);
			
			for (int i = 0; i < rows; i++) {
				
				Map<Object, Object> datamap = new HashMap<Object, Object>();
				
				for (int j = 0; j < cols; j++) {
					String key;
					String value;
					key = sh.getRow(0).getCell(j).getStringCellValue().trim();
					
					if (sh.getRow(i+1).getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
						
						value = sh.getRow(i+1).getCell(j).getStringCellValue().trim();
						
					}else {
						
						value = sh.getRow(i+1).getCell(j).getRawValue().trim();
					}
					

					datamap.put(key,value);
				}

				obj[i][0] = datamap;
			}
					
		return obj;
		
	}
}
