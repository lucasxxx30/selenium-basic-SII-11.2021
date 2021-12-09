package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductsGridPage extends BasePage{
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> allProducts;

    public void openRandomProduct(){
        getRandomElement(allProducts).click();
    }
}
