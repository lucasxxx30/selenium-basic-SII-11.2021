import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase {

    @Test
    public void shouldDropElement() {
        driver.get("https://demoqa.com/droppable");

        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(drag, drop)
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldMoveElement() {
        driver.get("https://demoqa.com/droppable");

        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");

    }
}
