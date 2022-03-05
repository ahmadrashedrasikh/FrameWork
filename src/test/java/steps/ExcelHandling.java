package steps;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelHandling extends CommonMethods {

    public static Workbook workbook;
    public static Sheet sheet;

    public static void openWorkbook(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    public static int rowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int colsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String cellData(int rowIndex, int colsIndex) {
        return sheet.getRow(rowIndex).getCell(colsIndex).toString();
    }

    public static List<Map<String, String>> getListOfMap(String filePath, String sheetName) {
        openWorkbook(filePath);
        openSheet(sheetName);

        List<Map<String, String>> listData = new ArrayList<>();

        for (int row = 1; row < rowCount(); row++) {

            Map<String, String> map = new LinkedHashMap<>();

            for (int cols = 0; cols < colsCount(row); cols++) {
                map.put(cellData(0, cols), cellData(row, cols));
            }
            listData.add(map);
        }

        return listData;
    }

    public static void main(String[] args) {

        openBrowser();
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropValue("password"));
        clickMethod(loginPage.loginButton);

        DashboardPage dashboardPage = new DashboardPage();
        clickMethod(dashboardPage.pimButton);
        clickMethod(dashboardPage.employeeAddButton);

        AddEmployeePage add = new AddEmployeePage();
        List<Map<String, String>> newEmployees = ExcelHandling.getListOfMap(Constants.EXCEL_PATH, "EmployeesData");

        Iterator<Map<String, String>> itr = newEmployees.iterator();

        while (itr.hasNext()) {
            Map<String, String> enter = itr.next();
            sendText(add.firstName, enter.get("FirstName"));
            sendText(add.middleName, enter.get("MiddleName"));
            sendText(add.lastName, enter.get("LastName"));
            sendText(add.photograph, enter.get("Photograph"));
            clickMethod(add.saveButton);
            clickMethod(dashboardPage.employeeAddButton);
        }
        tearDown();
    }
}
