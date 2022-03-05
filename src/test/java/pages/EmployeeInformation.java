package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeInformation extends CommonMethods {

    @FindBy(id = "empsearch_id")
    public WebElement empSearchBox;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr")
    public List<WebElement> nameList;

    @FindBy(xpath ="//*[@id='resultTable']/tbody/tr[1]/td[3]/a")
    public WebElement nameListFirstEle;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement nameSearchBox;

    @FindBy(id = "btnSave")
    public WebElement editButtonAndSaveButton;

    public EmployeeInformation(){
        PageFactory.initElements(webDriver,this);

    }

}
