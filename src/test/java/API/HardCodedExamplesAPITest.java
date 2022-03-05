package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HardCodedExamplesAPITest {

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDU2NzI1MjcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTcxNTcyNywidXNlcklkIjoiMzQ5NSJ9.z3CChRijVNGkDOFlqdtYkgJFc0qubeOdujT38qSRuKc";
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

@Test
    public void getOneEmployeeDetails() {
        // given

        RequestSpecification request = given().header("Authorization", token).header("Content-Type",
                "application/json").queryParam("employee_id", "19991272");

        //when
        Response response = request.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        //then

    response.then().assertThat().statusCode(200);


    }

}
