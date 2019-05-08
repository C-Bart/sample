package pages;

import bc.artest.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private String baseURL = Configuration.get("baseURL") + "/login";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    private WebElement loginInputField;

    @FindBy(xpath = "//input[@placeholder='Hasło']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[text()='Zaloguj się']")
    private WebElement submitButton;

    public String getBaseURL() {
        return baseURL;
    }

    public LoginPage fillLoginInput(String login) {
        loginInputField.sendKeys(login);
        return this;
    }

    public LoginPage clearLoginInput() {
        loginInputField.clear();
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    public LoginPage clearPasswordInput() {
        passwordInputField.clear();
        return this;
    }

    public LoginPage submitLoginForm() {
        submitButton.click();
        return this;
    }
}