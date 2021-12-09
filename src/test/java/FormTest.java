import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Jan");

        driver.findElement(By.name("lastname")).sendKeys("Kowalski");

        driver.findElement(By.cssSelector("#customer-form [name='email']"))
                .sendKeys(RandomStringUtils.randomAlphabetic(10) + "@wp.pl");

        List<WebElement> genders = driver.findElements(By.cssSelector("[name='id_gender']"));
        genders.get(0).click();

        driver.findElement(By.name("password")).sendKeys("Kowalski");

        driver.findElement(By.cssSelector("[name='customer_privacy']")).click();
        driver.findElement(By.cssSelector("[name='psgdpr']")).click();
        driver.findElement(By.cssSelector(".form-control-submit")).click();

        String actual = driver.findElement(By.cssSelector(".user-info span")).getText();
        Assert.assertEquals(actual, "Jan Kowalski");


    }
}