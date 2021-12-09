import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait extends TestBase {

    @Test
    public void shouldFail() {
        driver.get("http://146.59.32.4/index.php");
        driver.findElement(By.cssSelector("#qweasdzxc123"));
    }

    @Test
    public void shouldFailAfter10s() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://146.59.32.4/index.php");
        driver.findElement(By.cssSelector("#qweasdzxc123"));
    }
}
