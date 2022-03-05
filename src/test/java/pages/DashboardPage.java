package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimButton;

    @FindBy (linkText = "Add Employee")
    public WebElement employeeAddButton;


    @FindBy(id = "personal_txtEmployeeId")
    public WebElement empID;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListButton;

    @FindBy(xpath = "//*[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    public DashboardPage(){
        PageFactory.initElements(webDriver,this);
    }

}
