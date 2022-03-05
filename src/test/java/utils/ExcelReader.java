package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelReader {
    public static Workbook workbook;
    public static Sheet sheet;

    public static void openExcel(String filePath) {

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSheet(String sheetName) {
        sheet=workbook.getSheet(sheetName);
    }


    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowIndex) {

        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex, int colsIndex) {

        return sheet.getRow(rowIndex).getCell(colsIndex).toString();
    }

    public static List<Map<String, String>> excelIntoListMap(String filePath, String sheetName) {
        // get to filepath and sheet name
        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String>> listData = new ArrayList<>();

        for (int row = 1; row < getRowCount(); row++) {

            Map<String, String> map1 = new LinkedHashMap<>();

            for (int cols = 0; cols < getColsCount(row); cols++) {
                map1.put(getCellData(0, cols), getCellData(row, cols));

            }
            //to add the map in list
            listData.add(map1);
        }
        return listData;
    }
}
