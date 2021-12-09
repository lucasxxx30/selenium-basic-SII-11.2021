import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends TestBase {

    @Test
    public void shouldAcceptDelayedAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("#timerAlertButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    @Test
    public void shouldWaitForTextInLoadingBar() {
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.cssSelector("#startStopButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".progress-bar"), "100%"));

        String progress = driver.findElement(By.cssSelector(".progress-bar")).getText();
        Assert.assertEquals(progress, "100%");
    }

    @Test
    public void shouldWaitForTextInLoadingBar2() {
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.cssSelector("#startStopButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement progressBar = driver.findElement(By.cssSelector(".progress-bar"));

        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));

        Assert.assertEquals(progressBar.getText(), "100%");
    }


    @Test
    public void shouldWaitForAttributeValueInLoadingBar() {
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.cssSelector("#startStopButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".progress-bar"), "aria-valuenow", "100"));


        String progress = driver.findElement(By.cssSelector(".progress-bar")).getText();
        Assert.assertEquals(progress, "100%");
    }


    @Test
    public void shouldWaitForAttributeValueInLoadingBar2() {
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.cssSelector("#startStopButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".progress-bar"), "class", "bg-success"));

        String progress = driver.findElement(By.cssSelector(".progress-bar")).getText();
        Assert.assertEquals(progress, "100%");
    }
}
