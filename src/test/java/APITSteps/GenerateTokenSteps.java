package APITSteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    public static String Token;

    String baseURI;

    public GenerateTokenSteps(){
         baseURI= RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    }

    @Given("a JWT token is generated")
    public void a_jwt_token_is_generated() {
        //given
        RequestSpecification request = given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"sultan3@gmail.com\",\n" +
                        "  \"password\": \"sultan123\"\n" +
                        "}");

        Response response = request.when().post("/generateToken.php");
        Token = "Bearer " + response.jsonPath().getString("token");
        response.prettyPrint();
    }
}
