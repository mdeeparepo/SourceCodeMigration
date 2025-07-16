package com.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

//import org.apache.poi.xssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;

public class ReadDatafromExcel {

	public static HashMap<String, String> storeValues = new HashMap<String, String>();

	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					
					if(currentCell != null) {
						switch (currentCell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
							break;
						}
					}
				}
				mydata.add(currentHash);
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
	
	/*
	 * Method to write data to excel sheet
	 */
	public static void writeToExcel(String filePath,String sheetName,String dataToWrite) {
			
			try{
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
		        FileInputStream fs = new FileInputStream(filePath);
		        XSSFWorkbook workbook = new XSSFWorkbook(fs);
		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		        Row row = sheet.getRow(0);
		        Row newRow = sheet.createRow(rowCount);
		       
		        for(int j = 0; j < row.getLastCellNum(); j++){
		            Cell cell1 = newRow.createCell(j);
		            cell1.setCellValue(dataToWrite);
		            
		        }		        
		        	Cell cell2 = newRow.createCell(1);
	            	cell2.setCellValue(sdf.format(date));
		            fs.close();
		            FileOutputStream outputStream = new FileOutputStream(filePath);
		            workbook.write(outputStream);
		            outputStream.close();
		        
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	public static void writeToExcel(String filePath,String sheetName,String[] dataToWrite) {
		
		try{
	        FileInputStream fs = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fs);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	        Row row = sheet.getRow(0);
	        Row newRow = sheet.createRow(rowCount+1);
	        
	        for(int j = 0; j < row.getLastCellNum(); j++){
	            Cell cell = newRow.createCell(j);
	            cell.setCellValue(dataToWrite[j]);
	        }
	            fs.close();
	            FileOutputStream outputStream = new FileOutputStream(filePath);
	            workbook.write(outputStream);
	            outputStream.close();
	        
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> rowColNum(String filepath, String sheetName,String colName) {
        
        ArrayList<Integer> colRow = new ArrayList<Integer>();
        
        try {
               FileInputStream fs = new FileInputStream(filepath);
               XSSFWorkbook workbook = new XSSFWorkbook(fs);
               XSSFSheet sheet = workbook.getSheet(sheetName);
               
               //Get the Ordernumber column, from the first row
               Row getOrderrow = sheet.getRow(0);
                          
               for (int j = 0; j < getOrderrow.getPhysicalNumberOfCells(); j++) {
                      Cell currentCell = getOrderrow.getCell(j);
                     if(currentCell.getStringCellValue().equalsIgnoreCase(colName))
                     {
                            colRow.add(currentCell.getColumnIndex());
                            break;
                     }
               }      
                         
               
               //Search for each row,and get the row which has no order number 
               if(colRow.size() == 1)
               {
	               for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
	                       Row currentRow = sheet.getRow(i);
	                       Cell currentCelll = currentRow.getCell(colRow.get(0));
	                       
	                       if(currentCelll.getStringCellValue().isEmpty() || currentCelll.getStringCellValue()== null)
	                       {
	                              colRow.add(i);      
	                              break;
	                       }                                                                    
	                     
	               }
               }
               
               fs.close();                
               return colRow;      
        } catch (Exception e) {
               e.printStackTrace();
        }
        return colRow;
 }


	
	public static void updateExcel(String filepath, String sheetName, int rowNum, int colNum,String columnValue) {
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);		
			Cell cell = null;
			cell = sheet.getRow(rowNum).getCell(colNum);
            cell.setCellValue(columnValue);
            fs.close();
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            outputStream.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
public static int getColNum(String filepath, String sheetName,String colName) {
        
        int colNum = 0;
        
        try {
               FileInputStream fs = new FileInputStream(filepath);
               XSSFWorkbook workbook = new XSSFWorkbook(fs);
               XSSFSheet sheet = workbook.getSheet(sheetName);
               
               //Get the Ordernumb column, from the first row
               Row getOrderrow = sheet.getRow(0);
                          
               for (int j = 0; j < getOrderrow.getPhysicalNumberOfCells(); j++) {
                      Cell currentCell = getOrderrow.getCell(j);
                     if(currentCell.getStringCellValue().equalsIgnoreCase(colName))
                     {
                    	 	colNum = currentCell.getColumnIndex();
                            break;
                     }
               }       
               fs.close();                
               return colNum;      
        } catch (Exception e) {
               e.printStackTrace();
        }
        return colNum;
 }

public static int testDataRowNum(String filepath, String sheetName,String colName,String value) {
    
	int colNum=0;
    ArrayList<Integer> colRow = new ArrayList<Integer>();
    
    try {
           FileInputStream fs = new FileInputStream(filepath);
           XSSFWorkbook workbook = new XSSFWorkbook(fs);
           XSSFSheet sheet = workbook.getSheet(sheetName);
           
           //Get the column, from the first row
           Row getOrderrow = sheet.getRow(0);
                      
           for (int j = 0; j < getOrderrow.getPhysicalNumberOfCells(); j++) {
                  Cell currentCell = getOrderrow.getCell(j);
                 if(currentCell.getStringCellValue().equalsIgnoreCase(colName))
                 {
                        colRow.add(currentCell.getColumnIndex());
                        break;
                 }
           }      
                     
           
           //Search for each row,and get the row which the value
           if(colRow.size() == 1)
           {
               for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                       Row currentRow = sheet.getRow(i);
                       Cell currentCelll = currentRow.getCell(colRow.get(0));
                       
                       if(currentCelll.getStringCellValue().equalsIgnoreCase(value))
                       {
                              colRow.add(i); 
                              colNum = colRow.get(1);
                              break;
                       }                                                                    
                     
               }
           }
           
           fs.close();   
           
           return colNum;      
    } catch (Exception e) {
           e.printStackTrace();
    }
    return colNum;
}
	

public static boolean isCellEmpty(String filepath, String sheetName,int row, int col) {
    
	   boolean isCellEmpty = false;
	    
	    try {
	           FileInputStream fs = new FileInputStream(filepath);
	           XSSFWorkbook workbook = new XSSFWorkbook(fs);
	           XSSFSheet sheet = workbook.getSheet(sheetName);
	           col--;
	          if(sheet.getRow(row).getCell(col).getStringCellValue().isEmpty())
	        	  isCellEmpty=true; 
	           fs.close();                     
	    } catch (Exception e) {
	           e.printStackTrace();
	    }
	    return isCellEmpty;
	}



public static String readCellValue(String filepath, String sheetName,int row, int col) {
	String cellValue="";
	    try {
	    	
	           FileInputStream fs = new FileInputStream(filepath);
	           XSSFWorkbook workbook = new XSSFWorkbook(fs);
	           XSSFSheet sheet = workbook.getSheet(sheetName);
	           cellValue = sheet.getRow(row).getCell(col).getStringCellValue();
	           fs.close();  
	           
	    } catch (Exception e) {
	           e.printStackTrace();
	    }
		return cellValue;
		
	 
	}

private static final String ExcelPath = "src/test/resources/testdata/Credentials.xlsx";

public static String Username(String SheetName,String UsernameType,String ColumnNameoftheRowValue,String UsernameColumn) throws Exception{
    
     System.out.println("Retrieving Username..");
     try {
     int rownumber = testDataRowNum(ExcelPath,SheetName,ColumnNameoftheRowValue,UsernameType);
     String username = data(ExcelPath, SheetName).get(rownumber).get(UsernameColumn);
     if(username.equalsIgnoreCase(UsernameColumn)) {
         username = data(ExcelPath, SheetName).get(rownumber+1).get(UsernameColumn); 
     }
     return username;
     }
     catch(Exception e) {
         //FunctionalLibrary.logStep(LogStatus.FAIL, "Username Field Error", "Unable to retrieve USername ",true);
         throw new Exception("Error while getting USername,Check if your Username Field in Excel sheet has extra spaces or name");    



     }
}
public static String getURL(String SheetName,String PasswordType,String ColumnNameoftheRowValue,String PasswordColumn) throws Exception{
    System.out.println("Retrieving URL..");
    try {
    int rownumber = testDataRowNum(ExcelPath,SheetName,ColumnNameoftheRowValue,PasswordType);
     String url = data(ExcelPath, SheetName).get(rownumber).get(PasswordColumn);
     if(url.equalsIgnoreCase(PasswordColumn)) {
         url = data(ExcelPath, SheetName).get(rownumber+1).get(PasswordColumn); 
     }
     return url;



}
catch(Exception e) {
    //FunctionalLibrary.logStep(LogStatus.FAIL, "Password Field Error", "Unable to retrieve Password ",true);
     throw new Exception("Error while getting Password,Check if your Password Field in Excel sheet has extra spaces or name");    



}
}

public static String Password(String SheetName,String PasswordType,String ColumnNameoftheRowValue,String PasswordColumn) throws Exception{
    System.out.println("Retrieving Password..");
    try {
    int rownumber = testDataRowNum(ExcelPath,SheetName,ColumnNameoftheRowValue,PasswordType);
     String password = data(ExcelPath, SheetName).get(rownumber).get(PasswordColumn);
     if(password.equalsIgnoreCase(PasswordColumn)) {
         password = data(ExcelPath, SheetName).get(rownumber+1).get(PasswordColumn); 
     }
     return password;



}
catch(Exception e) {
    //FunctionalLibrary.logStep(LogStatus.FAIL, "Password Field Error", "Unable to retrieve Password ",true);
     throw new Exception("Error while getting Password,Check if your Password Field in Excel sheet has extra spaces or name");    



}
}

public static void updateCellValue(String filepath, String sheetName, int rowIndex, String columnName, String newValue) {
    try {
        FileInputStream fs = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowIndex);
        if (row == null) row = sheet.createRow(rowIndex);

        Row headerRow = sheet.getRow(0);
        int colIndex = -1;

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String header = headerRow.getCell(i).getStringCellValue();
            if (header.equalsIgnoreCase(columnName)) {
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) throw new Exception("Column '" + columnName + "' not found.");

        Cell cell = row.getCell(colIndex);
        if (cell == null) cell = row.createCell(colIndex);
        cell.setCellValue(newValue);

        fs.close();
        FileOutputStream output = new FileOutputStream(filepath);
        workbook.write(output);
        output.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public static ArrayList<Double> datawithheaderrowvalue(String filepath, String sheetName,
		int headerrow,int revenucecontractnum,String contractidentifier) throws Exception {
	
	//This returns BatchID and ProcessID in an arraylist
	ArrayList<Integer> valuescols = new ArrayList<Integer>();	
	ArrayList<Double> values = new ArrayList<Double>();	
	
	
	try {
		FileInputStream fs = new FileInputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet(sheetName);	
		Row HeaderRow = sheet.getRow(headerrow);
        int contractIdentifier =0;
        int revenueContract=0;
        int batchid=0;
        int ProcessID=0;
        Cell currentCell;
        Cell currentCell1;
        Cell currentCell2;
        Cell currentCell3;
        
        for (int j = 0; j < HeaderRow.getPhysicalNumberOfCells(); j++) {
            currentCell = HeaderRow.getCell(j);
           if(currentCell.getStringCellValue().equalsIgnoreCase("Revenue Contract Number"))
           {
        	   revenueContract = currentCell.getColumnIndex();
        	   valuescols.add(revenueContract);      	   
        	   break;
           }
        }
        
        for (int j = 0; j < HeaderRow.getPhysicalNumberOfCells(); j++) {
            currentCell1 = HeaderRow.getCell(j);
           if(currentCell1.getStringCellValue().equalsIgnoreCase("Contract Identifier"))
           {
        	   contractIdentifier = currentCell1.getColumnIndex();
        	   valuescols.add(contractIdentifier);       	   
        	   break;
           }
        }
        
        for (int j = 0; j < HeaderRow.getPhysicalNumberOfCells(); j++) {
        	currentCell2 = HeaderRow.getCell(j);
           if(currentCell2.getStringCellValue().equalsIgnoreCase("Process ID"))
           {
        	   ProcessID = currentCell2.getColumnIndex();
        	   valuescols.add(ProcessID);       	   
        	   break;
           }
        }
        
        for (int j = 0; j < HeaderRow.getPhysicalNumberOfCells(); j++) {
            currentCell3 = HeaderRow.getCell(j);
           if(currentCell3.getStringCellValue().equalsIgnoreCase("Batch ID"))
           {
        	   batchid = currentCell3.getColumnIndex();
        	   valuescols.add(batchid);       	   
        	   break;
           }
        }
        
        
	if(valuescols.size()!=4)
	{ return values;			
	}
	
	Row currentRow;
	Cell currentCelContIden;
	Cell currentCelRevecont;
	Cell currentCelBatchID;
	Cell currentCelProcessID;
	for (int i = headerrow+1; i <sheet.getPhysicalNumberOfRows(); i++) {	 
        currentRow = sheet.getRow(i);        
        currentCelContIden = currentRow.getCell(contractIdentifier);        
        if(currentCelContIden.getStringCellValue().equals(contractidentifier))
        {
        	currentCelRevecont = currentRow.getCell(revenueContract);  
        	if(currentCelRevecont.getNumericCellValue() == revenucecontractnum)
        	{      		
        		currentCelBatchID = currentRow.getCell(batchid);
        		values.add(currentCelBatchID.getNumericCellValue());        		
        		currentCelProcessID = currentRow.getCell(ProcessID);
        		values.add(currentCelProcessID.getNumericCellValue());
        		break;
        	}              
        }                                                                                        
}		    
	fs.close();
	} catch (Exception e) {
		throw new Exception("Unable to pick Process ID and Batch ID from Reconciliation Report");
	}
	return values;
}

public static String getTestDataValue(String SheetName,String PasswordType,String ColumnNameoftheRowValue,String PasswordColumn) throws Exception{
    System.out.println("Retrieving Password..");
    try {
    int rownumber = testDataRowNum(ExcelPath,SheetName,ColumnNameoftheRowValue,PasswordType);
     String password = data(ExcelPath, SheetName).get(rownumber).get(PasswordColumn);
     if(password.equalsIgnoreCase(PasswordColumn)) {
         password = data(ExcelPath, SheetName).get(rownumber+1).get(PasswordColumn); 
     }
     return password;



}
catch(Exception e) {
    //FunctionalLibrary.logStep(LogStatus.FAIL, "Password Field Error", "Unable to retrieve Password ",true);
     throw new Exception("Error while getting Password,Check if your Password Field in Excel sheet has extra spaces or name");    



}
}
	
};