package Automation.Guru99Project.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Taskdownload {
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    //File dir = new File(downloadPath);
	 //   File[] dir_contents = dir.listFiles();
	  	    
	  //  for (int i = 0; i < dir_contents.length; i++) {
	    	if(getLatestFilefromDir(downloadPath).getName().contains(fileName)) {
	     //   if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	public static boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	  //  if (files == null || files.length == 0) {
	        flag = false;
	   // }
	    System.out.println(getLatestFilefromDir(dirPath).getName());
	    String[] name =getLatestFilefromDir(dirPath).getName().split("Z", 2);
	    System.out.println(name[1].split(".c")[0]);
	   if( name[1].split(".c")[0].equals(ext)) {
		   
	    //for (int i = 1; i < files.length; i++) {
	    //	if(files[i].getName().split(".")[1].equals(ext)) {
	    		flag=true;
	    	
	    }
	    return flag;
	}
	
	
	/* Get the latest file from a specific directory*/
	public static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	//--------------------------------------------------------------
	public static int getRecordsCountInCSV(String downloadPath, String csvFileName) {
		int physicalRows = 0;
		try {
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +csvFileName);
				//	FileReader fr = new FileReader(file);
				/*	LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					linenumberreader.close();*/
					FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
					//creating Workbook instance that refers to .xlsx file  
					
					XSSFWorkbook wb = new XSSFWorkbook(fis);   
					XSSFSheet sheet = wb.getSheetAt(0); 
					 physicalRows = (sheet.getPhysicalNumberOfRows()-1);
					System.out.println(physicalRows);
				} else {
					System.out.println("File does not exists");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return physicalRows;
	}
	
	public static String getTodaydate() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
				
		String date= OffsetDateTime
        .now( ZoneOffset.UTC )
        .toString();
		String subdate= date.substring(0, 11);
		//System.out.println(subdate);
		return subdate;
	}
	
	
	
}
