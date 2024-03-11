package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Utilities {
	public  static String timestamp() {
		
		// TODO Auto-generated method stub
		Date date=new Date();
		
        String datetext=(date.toString().replace(" ", "_").replace(":", "_"));
        return datetext+"@gmail.com";

}
	public static Object [][] getexceldata(String sheetname) throws IOException  {
		File f=new File(".//src//test//java//resources//textdata.xlsx");
		FileInputStream file=new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	 XSSFSheet sheet=workbook.getSheet(sheetname);
	int rows= sheet.getLastRowNum();
	int columns=sheet.getRow(0).getLastCellNum();
	Object [][] data=new Object[rows][columns];
	for (int i=0;i<rows;i++) {
		XSSFRow row=sheet.getRow(i+1);
		for(int j=0;j<columns;j++) {
		XSSFCell cell=	row.getCell(j);
		CellType cellstypes =cell.getCellType();
		switch(cellstypes) {
		case STRING:
		data [i][j] =cell.getStringCellValue();
		break;
		case NUMERIC:
		data[i][j]=	Integer.toString((int)cell.getNumericCellValue());
		
			
			
		}
		}
	}
	return data;
		
	}
}