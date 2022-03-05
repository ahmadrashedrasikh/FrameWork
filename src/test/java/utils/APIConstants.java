package utils;

import io.restassured.RestAssured;

public class APIConstants {

    public static final String BASE_URI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_USER_URI = BASE_URI + "/createUser.php";
    public static final String GENERATE_TOKEN_URI = BASE_URI + "/generateToken.php";
    public static final String GET_ALL_EMPLOYEES_URI = BASE_URI + "/getAllEmployees.php";
    public static final String GET_ONE_EMPLOYEE_URI = BASE_URI + "/getOneEmployee.php";
    public static final String GET_EMPLOYMENT_STATUS_URI = BASE_URI + "/employeementStatus.php";
    public static final String GET_JOB_TITLE_URI = BASE_URI + "/jobTitle.php";
    public static final String CREATE_EMPLOYEE_URI = BASE_URI + "/createEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = BASE_URI + "/updateEmployee.php";
    public static final String DELETE_EMPLOYEE_URI = BASE_URI + "/deleteEmployee.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI = BASE_URI + "/updatePartialEmplyeesDetails.php";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE = "application/json";


}
