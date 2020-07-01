package com.bl.selenium.poi;

import com.bl.selenium.base.Base;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class DataDriven extends Base {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public void initializeSheet(String excelPath) {
        try {
            File file = new File(excelPath);
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public String getData(int sheetNumber, int row, int column) {
        sheet = workbook.getSheetAt(sheetNumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getTotalRows(int sheetIndex) {
        int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
        return row;
    }
}
