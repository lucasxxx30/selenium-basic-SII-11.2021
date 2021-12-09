package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".user-info .account")
    private WebElement loggedUserName;

    @FindBy(css=".user-info span")
    private WebElement signIn;

    public String getLoggedUserName(){
        return loggedUserName.getText();
    }

    public SignInPage goToSignIn(){
        signIn.click();
        return new SignInPage(driver);
    }
}
