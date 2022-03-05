package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.EmployeeInformation;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropValue("password"));
        jsClick(loginPage.loginButton);
    }

    @Given("user is logged in with valid credentials")
    public void user_is_logged_in_with_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropValue("password"));
        clickMethod(loginPage.loginButton);
    }

    @Given("user navigate to employee list page")
    public void user_navigate_to_employee_list_page() {
        DashboardPage dashboardPage = new DashboardPage();
        clickMethod(dashboardPage.pimButton);
        clickMethod(dashboardPage.employeeListButton);
    }

    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        EmployeeInformation empInfo = new EmployeeInformation();
        sendText(empInfo.empSearchBox, "238900000");

    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeInformation empInfo = new EmployeeInformation();
        clickMethod(empInfo.searchButton);

    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Info is Displayed - This is HW");

    }


    @When("user enters valid employee name")
    public void user_enters_validd_employee_name() {
        EmployeeInformation empInfo = new EmployeeInformation();
        sendText(empInfo.empSearchBox,"Donald");
    }

    @When("user wants to print list of maps")
    public void user_wants_to_print_list_of_maps(DataTable listOfMaps) {

        List<Map<String,String>> maps=listOfMaps.asMaps();
        System.out.println(maps);

        for (Map<String, String> mapName:maps) {
            System.out.println(mapName);
            String firstName=mapName.get("firstName");
            String lastName=mapName.get("lastName");
            String middleName=mapName.get("middleName");
        }
    }

    @When("user would like to print list of objects")
    public void user_would_like_to_print_list_of_objects(DataTable employeesTable) {

        DataTable name=employeesTable;
        System.out.println(name.asMaps());
    }
}
