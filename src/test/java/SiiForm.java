import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

public class SiiForm extends TestBase{

    @Test
    public void shouldFillForm(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        Select selectContinents = new Select(driver.findElement(By.id("selectContinents")));

        selectContinents.selectByIndex(3);

        Select selectSeleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));

        selectSeleniumCommands.selectByVisibleText("Browser Commands");

        File file = new File("src/main/resources/file.txt");

        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

    }
}
