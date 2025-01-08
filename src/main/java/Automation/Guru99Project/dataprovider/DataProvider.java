package Automation.Guru99Project.dataprovider;

import java.util.HashMap;
import java.util.Map;
import Automation.Guru99Project.Utility.NewExcelLibrary;

public class DataProvider {
NewExcelLibrary obj = new NewExcelLibrary();
	
	@org.testng.annotations.DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}
	
	
	@org.testng.annotations.DataProvider(name = "CreateIssue")
	public Object[][] getProduct() {
		// Totals rows count
		int rows = obj.getRowCount("CreateIssue");
		// Total Columns
		int column = obj.getColumnCount("CreateIssue");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}
	
	
	@org.testng.annotations.DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
}
