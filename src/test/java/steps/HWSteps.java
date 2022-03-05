package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.EmpPersonalDetails;
import pages.EmployeeInformation;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HWSteps extends CommonMethods {


    @And("user enter employee full name {string}")
    public void userSearchTheEmployeeByName(String employeeName) {
        EmployeeInformation empInfo = new EmployeeInformation();
        sendText(empInfo.nameSearchBox, employeeName);
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.ENTER).build().perform();
        clickMethod(empInfo.searchButton);
    }

    @Then("user modify the employee personal details by clicking on his or her name")
    public void userModifyEmployeePersonalDetailsByClickingOnHisHerName() {
        EmployeeInformation empInfo = new EmployeeInformation();
        clickMethod(empInfo.nameListFirstEle);

    }

    @Then("user clicks on edit button and can modify the employee's following personal details")
    public void user_clicks_on_edit_button_and_can_modify_the_employee_s_following_personal_details(DataTable dataTable) {

        EmpPersonalDetails add = new EmpPersonalDetails();


        List<Map<String, String>> personalDetails = dataTable.asMaps();

        List<WebElement> countries = webDriver.findElements(By.xpath("//*[@id='personal_cmbNation']/option"));

        List<String> countriesList = new ArrayList<>();

        for (WebElement element : countries) {
            countriesList.add(element.getText());
        }

        for (Map<String, String> empInfo : personalDetails) {
            clickMethod(add.editButtonAndSaveButton);

            String firstName = empInfo.get("firstName");
            String lastName = empInfo.get("lastName");
            String middleName = empInfo.get("middleName");
            String empId = empInfo.get("employeeID");
            String otherID = empInfo.get("otherID");
            String driverLicenseNumber = empInfo.get("driverLicenseNumber");
            String licenseExpiryDate = empInfo.get("licenseExpDate");
            String SSN_NUMBER = empInfo.get("SSN_NUMBER");
            String SIN_Number = empInfo.get("SIN_Number");
            String gender = empInfo.get("gender");
            String maritalStatusText = empInfo.get("maritalStatus");
            String nationalityText = empInfo.get("nationality");
            String DoB = empInfo.get("dateOfBirth");
            String nickName = empInfo.get("nickName");
            String militaryServices = empInfo.get("militaryService");


            sendText(add.firstName, firstName);
            sendText(add.lastName, lastName);
            sendText(add.middleName, middleName);
            sendText(add.empID, empId);
            sendText(add.otherID, otherID);
            sendText(add.driverLicense, driverLicenseNumber);
            sendText(add.licenseExpDate, licenseExpiryDate);
            sendText(add.SSN, SSN_NUMBER);
            sendText(add.SIN, SIN_Number);

            if (gender.equalsIgnoreCase("Male")) {
                clickMethod(add.genderMale);
            } else if (gender.equalsIgnoreCase("Female")) {
                clickMethod(add.genderFemale);
            } else {
                System.out.println("Invalid entry");
            }

            Select select = new Select(add.maritalStatus);
            select.selectByVisibleText(maritalStatusText);


            if (countriesList.contains(nationalityText)) {
                Select select1 = new Select(add.nationalities);
                select1.selectByVisibleText(nationalityText);
            } else {
                System.out.println("The nationality is not present in this list");
            }


            sendText(add.DateOfBirth, DoB);
            Actions actions = new Actions(webDriver);
            actions.sendKeys(Keys.ENTER).build().perform();

            sendText(add.nickName, nickName);

            String smoker = empInfo.get("smoker");
            if (smoker.contains("Yes")) {
                add.smokeFlag.click();
            } else {
                System.out.println("Not smoker");
            }

            sendText(add.militaryServices, militaryServices);

            clickMethod(add.editButtonAndSaveButton);


        }
        System.out.println(countriesList);
    }

}






