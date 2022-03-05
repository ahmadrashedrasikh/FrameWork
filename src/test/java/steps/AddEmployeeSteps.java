package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmpPersonalDetails;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;
import utils.GlobalVariablesDB;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {


    @Given("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dash = new DashboardPage();
        clickMethod(dash.pimButton);
    }

    @Given("user clicks on add employee list option")
    public void user_clicks_on_add_employee_list_option() {
        DashboardPage dash = new DashboardPage();
        clickMethod(dash.employeeAddButton);
    }

    @Given("user adds first name, middle name and last name")
    public void user_adds_first_name_middle_name_and_last_name() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Richard");
        sendText(addEmployeePage.lastName, "Charles");
        sendText(addEmployeePage.middleName, "P");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        clickMethod(addEmployeePage.saveButton);
    }

    @Then("new employee is added successfully")
    public void new_employee_is_added_successfully() throws InterruptedException {
//        AddEmployeePage addEmployeePage = new AddEmployeePage();
//        Assert.assertTrue(addEmployeePage.nameVerification.isDisplayed());
//        String nameText = addEmployeePage.nameVerification.getText();
//        Assert.assertTrue(nameText, true);
//        System.out.println(nameText);
//        Thread.sleep(2000);
    }

    @Given("user delete auto generated employee ID")
    public void user_delete_auto_generated_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeID.clear();
    }

    @Given("user thick create login credentials")
    public void user_thick_create_login_credentials() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.checkEmpButton.click();
    }

    @Given("user enter valid username, password,confirm password")
    public void user_enter_valid_username_password_confirm_password() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.userName, "Charles@007");
        sendText(addEmployeePage.userPassword, "Hum@nhrm123");
        sendText(addEmployeePage.rePassword, "Hum@nhrm123");
    }

    @Given("user adds first name {string}, middle name {string} and last name {string}")
    public void user_adds_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);

        GlobalVariablesDB.firstName = firstName;
        GlobalVariablesDB.middleName = middleName;
        GlobalVariablesDB.lastName = lastName;

    }

    @When("user adds {string}, {string},and {string}")
    public void user_adds_and(String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME) {
        AddEmployeePage addEmp = new AddEmployeePage();
        sendText(addEmp.firstName, FIRST_NAME);
        sendText(addEmp.middleName, MIDDLE_NAME);
        sendText(addEmp.lastName, LAST_NAME);
    }

    @When("user add and verify multiple employees from datatable")
    public void user_adding_multiple_employees_from_datatable(DataTable employees) throws InterruptedException {

        List<Map<String, String>> employeeNames = employees.asMaps();

        for (Map<String, String> employee : employeeNames) {
            String firstName = employee.get("firstname1");
            String lastName = employee.get("lastname1");
            String middleName = employee.get("middlename1");

            AddEmployeePage addEmp = new AddEmployeePage();
            sendText(addEmp.firstName, firstName);
            sendText(addEmp.middleName, middleName);
            sendText(addEmp.lastName, lastName);
            clickMethod(addEmp.saveButton);

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            Assert.assertTrue(addEmployeePage.nameVerification.isDisplayed());
            String nameText = addEmployeePage.nameVerification.getText();
            Assert.assertTrue(nameText, true);
            System.out.println(nameText);
            Thread.sleep(2000);

            DashboardPage dash = new DashboardPage();
            clickMethod(dash.employeeAddButton);
            Thread.sleep(2000);


        }
    }

    @When("adding multiple employees from Employees {string} sheet and verify them")
    public void adding_multiple_employees_from_employees_sheet(String sheetName) throws InterruptedException {
        AddEmployeePage ad = new AddEmployeePage();
        DashboardPage dash = new DashboardPage();

        List<Map<String, String>> newEmployees = ExcelReader.excelIntoListMap(Constants.EXCEL_PATH, sheetName);

        for (Map<String, String> map : newEmployees) {
            sendText(ad.firstName, map.get("FirstName"));
            sendText(ad.lastName, map.get("LastName"));
            sendText(ad.middleName, map.get("MiddleName"));
            sendText(ad.photograph, map.get("Photograph"));

            clickMethod(ad.saveButton);
            EmpPersonalDetails empAdd = new EmpPersonalDetails();
            String firstNamText = empAdd.firstName.getAttribute("value");
            String lastNamText = empAdd.lastName.getAttribute("value");
            String middleNameText = empAdd.middleName.getAttribute("value");
            System.out.println("FullName" + firstNamText + " " + lastNamText + " " + middleNameText);
            Assert.assertTrue(ad.nameVerification.isDisplayed());
            String nameText = ad.nameVerification.getText();
            System.out.println("Actual name " + nameText);
            Assert.assertEquals(nameText, firstNamText + " " + middleNameText + " " + lastNamText);
            clickMethod(dash.employeeAddButton);

        }
        tearDown();
    }

    @When("captures employee id")
    public void captures_employee_id() {
        AddEmployeePage ad = new AddEmployeePage();
        String empID = GlobalVariablesDB.empId = ad.employeeID.getAttribute("value");


    }

    @Then("verify employee data is matched UI and DB")
    public void verify_employee_data_is_matched_ui_and_db() {


        Assert.assertEquals(GlobalVariablesDB.firstName,GlobalVariablesDB.getMapFromDB.get("emp_firstname"));
        Assert.assertEquals(GlobalVariablesDB.getMapFromDB.get("emp_middle_name"), GlobalVariablesDB.middleName);
        Assert.assertEquals(GlobalVariablesDB.getMapFromDB.get("emp_lastname"), GlobalVariablesDB.lastName);


    }

}
