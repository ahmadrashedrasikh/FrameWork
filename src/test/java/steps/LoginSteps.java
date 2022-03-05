package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropValue("password"));

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage loginPage = new LoginPage();
        clickMethod(loginPage.loginButton);
    }
    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dash = new DashboardPage();

        String welcomeText = dash.welcomeMessage.getText();
        System.out.println(welcomeText);
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
        Assert.assertEquals(welcomeText, "Welcome Admin");

    }
    @When("user enters invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }
    @Then("user see invalid credential message on login page")
    public void user_see_invalid_credential_message_on_login_page() {
        LoginPage loginPage = new LoginPage();
        String errorText = loginPage.errorMessage.getText();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        System.out.println(errorText);
        Assert.assertEquals(errorText, "Invalid credentials");

    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropValue("username"));
        sendText(loginPage.passwordBox, "Sophia123");
    }

    @When("user login with invalid credentials for verifications")
    public void user_login_with_valid_and_invalid_credentials_verification(DataTable errorTable) {

        List<Map<String,String>> errorData=errorTable.asMaps();


        for (Map<String, String> errorMessage:errorData) {

            String usernameText=errorMessage.get("username");
            String passwordText=errorMessage.get("password");
            String errorMessageText=errorMessage.get("errorMessage");

            LoginPage login=new LoginPage();
            sendText(login.userNameBox,usernameText);
            sendText(login.passwordBox,passwordText);
            clickMethod(login.loginButton);
            String actualText=login.errorMessage.getText();

            Assert.assertEquals("Message doest not match",actualText,errorMessageText);
        }
    }

    @When("user login with invalid {string} and {string} for error verification {string}")
    public void user_login_with_invalid_and_for_error_verification(String username, String password, String errorMessage) {

        LoginPage login=new LoginPage();
        sendText(login.userNameBox,username);
        sendText(login.passwordBox,password);
        clickMethod(login.loginButton);
        String actualText=login.errorMessage.getText();

        Assert.assertEquals("Message doest not match",actualText,errorMessage);
    }


}
