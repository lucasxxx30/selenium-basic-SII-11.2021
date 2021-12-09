package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='id_gender']")
    private List<WebElement> genders;

    @FindBy(css = "[name='lastname']")
    private WebElement lastName;

    @FindBy(css = "#customer-form [name='email']")
    private WebElement email;

    @FindBy(css = "[name='password']")
    private WebElement password;

    @FindBy(css = "[name='psgdpr']")
    private WebElement gdpr;

    @FindBy(css = "[name='customer_privacy']")
    private WebElement policy;

    @FindBy(css = ".form-control-submit")
    private WebElement signUpBtn;

    public RegistrationPage setName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage selectMale() {
        genders.get(0).click();
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public RegistrationPage acceptGdpr() {
        gdpr.click();
        return this;
    }

    public RegistrationPage acceptPolicy() {
        policy.click();
        return this;
    }

    public MenuPage signUpUser() {
        signUpBtn.click();
        return new MenuPage(driver);
    }

}
