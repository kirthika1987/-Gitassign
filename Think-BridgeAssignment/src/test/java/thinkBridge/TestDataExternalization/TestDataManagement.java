package thinkBridge.TestDataExternalization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataManagement {
	
	public static XSSFWorkbook _wb;
	public static XSSFSheet _sheet;
	public static int _row;
	public static void loadTestDataFile() throws Exception{
		File f=new File(".");
		_wb=new XSSFWorkbook(new File(f.getCanonicalPath()+"\\src\\TestData1.xlsx"));
		_sheet=_wb.getSheetAt(0);
	}
	
	public static void freezeTestDataRow(String strTestCaseName) throws Exception{
		int rowSize=_sheet.getLastRowNum()+1;
		for(int i=0;i<rowSize;i++){
			if(_sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(strTestCaseName)){
				_row=i;
				break;
			}
		}
	}
	public static String getValue(String strColumnName) throws Exception{
		int colSize=_sheet.getRow(0).getLastCellNum();
		int colValue=0;
		for(int i=0;i<colSize;i++){
			if(_sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(strColumnName)){
				colValue=i;
				break;
			}
		}
		return _sheet.getRow(_row).getCell(colValue).getStringCellValue();
	}
	

	public static Properties loadPropertyFile(String strFilePath) throws Exception {
		FileReader reader = new FileReader(strFilePath);

		Properties prop = new Properties();
		prop.load(reader);
		return prop;
	}
}
