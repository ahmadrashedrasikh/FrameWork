package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmpPersonalDetails extends CommonMethods {

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement middleName;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='frmEmpPersonalDetails']/fieldset/ol[1]/li/ol")
    public WebElement fieldSet;

    @FindBy(id = "btnSave")
    public WebElement editButtonAndSaveButton;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement empID;

    @FindBy(id = "personal_txtOtherID")
    public WebElement otherID;

    @FindBy(id = "personal_txtLicenNo")
    public WebElement driverLicense;

    @FindBy (id = "personal_txtLicExpDate")
    public WebElement licenseExpDate;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr")
    public List<WebElement> DLExpCal;

    @FindBy(id = "personal_txtNICNo")
    public WebElement SSN;

    @FindBy(id = "personal_txtSINNo")
    public WebElement SIN;

    @FindBy(id  ="personal_optGender_1")
    public WebElement genderMale;

    @FindBy(id = "personal_optGender_2")
    public WebElement genderFemale;

    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatus;

    @FindBy(id = "personal_cmbNation")
    public WebElement nationalities;

    @FindBy(id = "personal_DOB")
    public WebElement DateOfBirth;

    @FindBy(id = "personal_txtEmpNickName")
    public WebElement nickName;

    @FindBy(id = "personal_chkSmokeFlag")
    public WebElement smokeFlag;

    @FindBy(id = "personal_txtMilitarySer")
    public WebElement militaryServices;






    public EmpPersonalDetails(){
        PageFactory.initElements(webDriver,this);
    }





}
