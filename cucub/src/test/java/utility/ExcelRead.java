package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String args[]) throws IOException {
		Object[][] myData=getDataFromExcelSheet("testdata/mytestdata.xlsx","LoginData");
		System.out.println(myData[0][0]);
		System.out.println(myData[0][1]);
		System.out.println(myData[0][2]);
	}
	
	public static Object[][] getDataFromExcelSheet(String excelPath,String sheetName) throws IOException {		
		XSSFWorkbook workbook=new XSSFWorkbook(excelPath);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=sheet.getRow(1);
		XSSFCell cell0=row.getCell(0);
		String cell0Value=cell0.getStringCellValue();
		//System.out.println(cell0Value);
		
		int rows=sheet.getLastRowNum();
		//System.out.println(rows);
		
		int columnCount1=row.getLastCellNum();
		Object[][] obj=new Object[rows][columnCount1];
		
		for(int i=1;i<=rows;i++) {
			XSSFRow myRow=sheet.getRow(i);
			int columnCount=myRow.getLastCellNum();
			//System.out.println(columnCount);
			for(int j=0;j<columnCount;j++) {
				String value=myRow.getCell(j).getStringCellValue();
				//System.out.println(value);
				obj[i-1][j]=value;
			}
		}
		
		//printing values from the object array
		//System.out.println("Values are coming from the Array");
		for(int i=0;i<obj.length;i++) {
			for(int j=0;j<obj[i].length;j++) {
				//System.out.println(obj[i][j]);
			}
		}
		workbook.close();
		return obj;
	}
	
	

}
