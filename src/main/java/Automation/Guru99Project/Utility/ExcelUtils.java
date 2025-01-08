package Automation.Guru99Project.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ExcelUtils {

	public static List<String[]> readExcelData(String filepath, String SheetName) throws IOException{
		List<String[]> datalist= new ArrayList<>();
		try 
			(FileInputStream fis= new FileInputStream(filepath);
			Workbook workbook= new XSSFWorkbook(fis)){
			Sheet sheet = workbook.getSheet(SheetName);
			if (sheet==null) {
				throw new 
				IllegalArgumentException("sheet "+SheetName+"does not exists");}
			for(Row row :sheet) {
				Cell keycell=row.getCell(0);
				Cell valuecell=row.getCell(1);
				Cell paword= row.getCell(2);
				if(keycell!= null && valuecell!=null) {
					String[] dataArray= new String[3];
					dataArray[0]=keycell.getStringCellValue();
					dataArray[1]= valuecell.getStringCellValue();
					dataArray[2]=paword.getStringCellValue();
					datalist.add(dataArray);
				}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datalist ;
	}
	
	
	
	
	@DataProvider(name="exceldata")
	public Object[][] excelDataprovider() throws IOException{
		String filepath="C:\\Users\\36814\\eclipse-workspace\\DRSProject\\src\\main\\java\\DRSTestData\\DeficiencyData.xlsx";
		String sheetname="Sheet1";
		
		List<String[]> datalist= ExcelUtils.readExcelData(filepath, sheetname);
		
		Object[][] dataArray= new Object[datalist.size()][3];
		
		for(int i=0;i<datalist.size();i++) {
			dataArray[i]=datalist.get(i);
		}
		
		/*
		 * for(Map.Entry<String, String> entry: data.entrySet()) {
		 * dataArray[index][0]=entry.getKey(); dataArray[index][1]=entry.getValue();
		 * index++; }
		 */
		return dataArray;
	}
	
	
}



