package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPopupPage extends BasePage {
    public ProductPopupPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("#blockcart-modal")));
    }

    @FindBy(css = ".cart-content-btn a")
    private WebElement proceedToCheckoutBtn;

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
}
