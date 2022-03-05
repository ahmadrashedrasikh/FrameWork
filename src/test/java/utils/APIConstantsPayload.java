package utils;

public class APIConstantsPayload {


    public static String createEmployeePayload(){

        return "{\n" +
                "  \"emp_firstname\": \"Lauran\",\n" +
                "  \"emp_lastname\": \"Arabia\",\n" +
                "  \"emp_middle_name\": \"Arabs\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-03-19\",\n" +
                "  \"emp_status\": \"Inactive\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}";
    }
}
