package com.excel.demo;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {

    @Test (dataProvider = "ExcelData")
    public void testThree(String name, String gmail, int phoneNum) {
        System.out.println(name + " | " + gmail + " | " + phoneNum);
    }

    @DataProvider (name = "ExcelData")
    public Object[][] ExcelRead() {

        try {
            InputStream inputStream = new FileInputStream("src/test/resources/excel/Book1.xlsx");
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet ci = workbook.getSheetAt(0);

            int rowLen = ci.getLastRowNum(); // 2
            int cellLen = ci.getRow(0).getLastCellNum(); // 3

            Object[][] data = new Object[rowLen][cellLen];

            for (Row row: ci) {
                Object temp = null;
                if (row.getRowNum() == 0) continue;
                // This loop will start when the row value is 1
                for (Cell cell: row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            temp = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            temp = (int) cell.getNumericCellValue();
                            break;
                    }
                    // getRowNum gives you number 1
                    // And getColumnIndex gives you number 0
                    data[row.getRowNum()-1][cell.getColumnIndex()] = temp;
                }
            }
            workbook.close();
            inputStream.close();
            return data;

        } catch (IOException e) {
            // use log instead
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
