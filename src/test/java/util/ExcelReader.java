package util;

import java.util.*;
import java.util.Map;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static List<Map<String,String>> read(String sheetName, String path){
		FileInputStream fis = null;
		List<Map<String,String>> excelData = new ArrayList<Map<String,String>>();
		try {
			fis = new FileInputStream(path);
			XSSFWorkbook xsfWorkbook = new XSSFWorkbook(fis);
			Sheet workSheet = xsfWorkbook.getSheet(sheetName);
			
			Row headerRow = workSheet.getRow(0);
			for(int row=1;row<workSheet.getPhysicalNumberOfRows(); row++) {
				Row clientData = workSheet.getRow(row);
				Map<String,String> rowMap = new LinkedHashMap<String, String>();
				
				for(int col=0;col<headerRow.getPhysicalNumberOfCells(); col++) {
					String key = headerRow.getCell(col).toString();
					String value = clientData.getCell(col).toString();
					rowMap.put(key, value);
				}
				excelData.add(rowMap);
			}
		}catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelData;
	}
}
