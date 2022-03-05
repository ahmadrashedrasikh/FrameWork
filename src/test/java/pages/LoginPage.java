package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public   WebElement userNameBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;


    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public  void login(String username, String password){
        sendText(userNameBox,username);
        sendText(passwordBox,password);
        clickMethod(loginButton);
    }
}
