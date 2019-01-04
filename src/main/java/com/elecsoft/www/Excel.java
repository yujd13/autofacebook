package com.elecsoft.www;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Excel {
    public static void main(String[] args) throws IOException {
        Object[] a = getExcelData("Accounts.xlsx", "Sheet1");
        System.out.println(Arrays.toString(a));


    }

    public static Object[] getExcelData(String filepath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filepath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet(sheetName);

        Iterator<Row> rowIterator = sh.rowIterator();
        rowIterator.next();


        Object[] result = new List[sh.getLastRowNum()];
        int i = 0;
        while(rowIterator.hasNext()) {
            Iterator<Cell> cellIterator =  rowIterator.next().cellIterator();
            List<String> objectList = new ArrayList<String>();
            while(cellIterator.hasNext()) {
                objectList.add(cellIterator.next().getStringCellValue());
            }
            result[i] = objectList;
            i++;
        }

        return  result;
    }

    // sample for reading excel files
    public static void readExcelFile(String filepath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filepath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet(sheetName);

        Iterator<Row> rowIterator = sh.rowIterator();
        rowIterator.next();
        while(rowIterator.hasNext()) {
            Iterator<Cell> cellIterator =  rowIterator.next().cellIterator();
            while(cellIterator.hasNext()) {
                System.out.println(cellIterator.next().getStringCellValue());
            }
        }

        fis.close();

    }

    // sample of writing excel file
    private static void writeExcelFile() throws IOException {
        File myFile = new File("mySheet.xlsx");
        FileOutputStream fos = new FileOutputStream(myFile);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet("FirstSheet");
        Row firstRow = sh.createRow(0);

        for(int i = 0; i < 3; i++){
            Row rows = sh.createRow(i);
            for(int j = 0; j < 3; j++){
                rows.createCell(j).setCellValue(i);
            }
        }
        wb.write(fos);
        fos.close();
    }

}
