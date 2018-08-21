package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReading {
	
	public File src;
	public FileInputStream fin;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public int rows;
	public int cols;
	public String key;
	public String value;
	public Object[][] obj;
	
	
	@DataProvider(name="hmsTestData")
	public Object[][] getExcelData(Method name) {
		
		String sheetName = name.getName();
		try {
			src = new File("./TestData/hms.xlsx");
			fin = new FileInputStream(src);
			wb  = new XSSFWorkbook(fin);
			sh  = wb.getSheet(sheetName);
			wb.close();
			rows = sh.getLastRowNum()-sh.getFirstRowNum();
			cols = sh.getRow(0).getLastCellNum();
			
			obj = new Object[rows][1];
			
			for (int i = 0; i < rows; i++) {
				
				Map<String, String> map = new HashMap<String,String>();
				
				for (int j = 0; j < cols; j++) {
					
					key = sh.getRow(0).getCell(j).getStringCellValue();
					
					if (sh.getRow(i+1).getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
						
						value = sh.getRow(i+1).getCell(j).getStringCellValue();
						
					}else {
						
						value = sh.getRow(i+1).getCell(j).getRawValue();
					}
					
					map.put(key, value);
				}
				
				obj[i][0] = map;	
			}	
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return obj;
		
	}
	
	/*public static void main(String[] args) {
		
		ExcelReading excel = new ExcelReading();
		
		excel.getExcelData();
	}*/

}
