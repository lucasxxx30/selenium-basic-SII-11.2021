import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoqaAutocompleteTest extends TestBase {

    @Test
    public void shouldFillAutocomplete() {
        driver.get("https://demoqa.com/automation-practice-form");


        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("Accounting");

        System.out.println(driver.findElement(By.cssSelector(".subjects-auto-complete__menu"))
                .getAttribute("innerHTML"));

        getElements(By.cssSelector(".subjects-auto-complete__option")).get(0).click();
        String selectedOption = getElements(By.cssSelector(".subjects-auto-complete__multi-value__label"))
                .get(0).getText();

        Assert.assertEquals(selectedOption, "Accounting");
    }

    public List<WebElement> getElements(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}