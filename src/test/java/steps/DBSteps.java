package steps;

import io.cucumber.java.en.Then;
import utils.DBUtils;
import utils.GlobalVariablesDB;

public class DBSteps {

    @Then("Query HRMS Database and get data")
    public void query_hrms_database_and_get_data() {
        String sqlQuery="select employee_id, emp_lastname,emp_firstname,emp_middle_name from hs_hr_employees where employee_id="+GlobalVariablesDB.empId;
       GlobalVariablesDB.getMapFromDB = DBUtils.getMapFromDB(sqlQuery);
    }

}
