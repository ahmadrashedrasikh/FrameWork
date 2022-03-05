package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APIHardCodeDemoTest {

    String URI;
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDU3NTk3NzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTgwMjk3NywidXNlcklkIjoiMzQ5NSJ9.EfN61d2DHY018-9mKjUu5YlYlkd7ekHptDUlhA6AF8U";
    static String employeeID;

    public APIHardCodeDemoTest() {
        URI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    }

    @Test
    public void acreateOneEmployee() {
        //given
        RequestSpecification request = given().header("Authorization", token).header("Content-Type", "application/json").body("{\n" +
                "  \"emp_firstname\": \"Lauran\",\n" +
                "  \"emp_lastname\": \"Arabia\",\n" +
                "  \"emp_middle_name\": \"Arabs\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1988-02-19\",\n" +
                "  \"emp_status\": \"Inactive\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}");

        //when
        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        employeeID = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employeeID);

        //then
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Lauran"));
        response.then().assertThat().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
        response.then().assertThat().body("Employee.employee_id", equalTo(employeeID));

    }


    @Test
    public void bgetDetailsOfCreatedEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employeeID);

        //when
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        String empID = response.jsonPath().getString("employee.employee_id");
        //then

        boolean comparingEmpIDs = empID.contentEquals(employeeID);
        Assert.assertTrue(comparingEmpIDs);


        String lastName = response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastName.contentEquals("Arabia"));


    }

    @Test
    public void cupdateEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body(employeeID +
                        "  \"emp_firstname\": \"JettUPDATED\",\n" +
                        "  \"emp_lastname\": \"xxxxxx\",\n" +
                        "  \"emp_middle_name\": \"MaverickUPDATED\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1988-12-19\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Architectural Engineer\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();


    }

}
