import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SiiIframe extends TestBase{
    @Test
    public void shouldFillIframe(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");

    }
}
