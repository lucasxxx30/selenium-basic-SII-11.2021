package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".add-to-cart")
    private WebElement addToBasketBtn;

    @FindBy(css = "h1")
    private WebElement productName;

    public void addToBasket() {
        addToBasketBtn.click();
    }

    public String getProductName() {
        return productName.getText();
    }
}
