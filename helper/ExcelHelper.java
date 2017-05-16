package com.wbl.helper;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	// creating log object for excelhelper class
	static Logger log = LogManager.getLogger(ExcelHelper.class);
	public static Object[][] getdata(String filename){
		Object[][] data=null;
		XSSFWorkbook wb=null;
		try {
			 wb =new XSSFWorkbook(new FileInputStream(filename)) ;
			XSSFSheet sheet= wb.getSheet("testdata");
			
			int rows=sheet.getLastRowNum();
			System.out.println("no of rows:"+rows+1);
			data=new Object[rows][];
			
			for(int i=1;i<=rows;i++){
				XSSFRow row=sheet.getRow(i);
				int cols=row.getLastCellNum();
				String[] coldata=new String[cols];
				
				for(int j=0;j<cols;j++){
					coldata[j]=row.getCell(j).getStringCellValue();
					}
				data[i-1]=coldata;
			}
			
			
		}  catch (IOException e) {
				//e.printStackTrace();
			log.error("ExcelHelper exception:"+e);
		} finally{
			try { if(null!=wb)
				wb.close();
			} catch (IOException e) {
						//e.printStackTrace();
				log.error(e);
			}
		}

		
		 	
		
		return data;
	}

}
