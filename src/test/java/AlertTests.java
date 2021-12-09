import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @Test
    public void shouldAcceptAlert() {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.cssSelector("#promtButton")).click();
        driver.switchTo().alert().sendKeys("Mat");
        driver.switchTo().alert().accept();

        String actual = driver.findElement(By.cssSelector("#promptResult"))
                .getText();

        Assert.assertEquals(actual, "You entered Mat");
    }
}
