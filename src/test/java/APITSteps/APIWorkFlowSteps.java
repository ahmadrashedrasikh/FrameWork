package APITSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIConstantsPayload;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIWorkFlowSteps {

    RequestSpecification request;
    Response response;
    public static String employeeID;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE).
                header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.Token).body(APIConstantsPayload.createEmployeePayload());
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int code) {
        response.then().assertThat().statusCode(code);
    }

    @Then("the created employee contains a key {string} and a value {string}")
    public void the_created_employee_contains_a_key_and_a_value(String message, String value) {

        response.then().assertThat().body(message, equalTo(value));
    }

    @Then("the employee ID is {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {

        employeeID = response.jsonPath().getString(empID);
        System.out.println(employeeID);
        System.out.println("################################################################################");
    }

    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {

        request = given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .header(APIConstants.HEADER_AUTHORIZATION, GenerateTokenSteps.Token)
                .queryParam("employee_id", employeeID);
    }

    @When("a GET call is made to retrieve the created employee")
    public void a_get_call_is_made_to_retrieve_the_created_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code for retrieving this employee is {int}")
    public void the_status_code_for_retrieving_this_employee_is(int code) {

        response.then().assertThat().statusCode(code);
    }

    @Then("the retrieved employee ID {string} should match global employee ID")
    public void the_retrieved_employee_id_should_match_global_employee_id(String IDFromResponse) {
//        String tempID = response.jsonPath().getString(IDFromResponse);
//        Assert.assertEquals(tempID, IDFromResponse);
    }

    @Then("the retrieved data at {string} object matches the data used to create an employee" +
            " with employee ID {string}")
    public void the_retrieved_data_at_object_matches_the_data_used_to_create_an_employee_with_employee_id
            (String employeeObject, String responseEMPID, DataTable dataTable) {

        List<Map<String, String>> expectedData = dataTable.asMaps();
        Map<String, String> actualData = response.body().jsonPath().get(employeeObject);

        int index=0;
        for (Map<String,String> map:expectedData) {
            Set<String> keySet=map.keySet();
            for (String key:keySet) {
                String expectedValue=map.get(key);
                String actualValue=actualData.get(key);

                Assert.assertEquals(expectedValue,actualValue);

            }
            index++;
        }

        String empID=response.body().jsonPath().getString(responseEMPID);
        Assert.assertEquals(empID,employeeID);
    }
}
