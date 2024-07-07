package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public static WebElement userNameField;

    @FindBy(id = "password")
    public static WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement submitButton;
}
