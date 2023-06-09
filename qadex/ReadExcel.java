package qadex;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	public static String[][] readData() throws IOException{
		
		XSSFWorkbook book = new XSSFWorkbook("./Data/addsupplier.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		int rowNum = sheet.getLastRowNum();
		int cellNum = row.getLastCellNum();
		String[][] data = new String[rowNum][cellNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				String alldata = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = alldata;
			
				
			}
		}
		book.close();
		return data;
	}
	

}
