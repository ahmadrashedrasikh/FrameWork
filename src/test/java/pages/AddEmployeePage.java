package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "middleName")
    public WebElement middleName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkEmpButton;

    @FindBy(id = "user_name")
    public WebElement userName;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(id = "re_password")
    public WebElement rePassword;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "employeeId")
    public WebElement employeeID;

    @FindBy(xpath = "//*[@id='profile-pic']/h1")
    public WebElement nameVerification;

    public AddEmployeePage(){
        PageFactory.initElements(webDriver,this);
    }

}
