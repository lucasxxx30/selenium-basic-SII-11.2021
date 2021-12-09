import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ProductDetailsPage;
import pages.ProductPopupPage;
import pages.ProductsGridPage;

public class BasketTest extends TestBase {

    @Test
    public void shouldAddProductToBasket() {
        driver.get("http://146.59.32.4/index.php");

        new ProductsGridPage(driver)
                .openRandomProduct();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        String expectedProductName = productDetailsPage.getProductName();

        productDetailsPage.addToBasket();

        new ProductPopupPage(driver)
                .proceedToCheckout();

        String actualProductName = new BasketPage(driver).getProductName();

        Assert.assertEquals(actualProductName, expectedProductName);
    }

}
