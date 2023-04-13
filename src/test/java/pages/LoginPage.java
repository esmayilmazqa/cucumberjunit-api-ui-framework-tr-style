package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

    @FindBy(css = "[name='email']")
    public WebElement txtEmail;

    @FindBy(css = "[name='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement btnLogin;



}
