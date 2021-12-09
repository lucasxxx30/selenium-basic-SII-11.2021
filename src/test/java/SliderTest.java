import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SliderTest extends TestBase {

    @Test
    public void shouldMoveSlider() {
        driver.get("https://demoqa.com/slider");
        moveTo(50);
        moveTo(1);
        moveTo(1);
        moveTo(100);
    }

    public void moveTo(int expectedSliderValue) {
        if (getSliderValue() < expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_RIGHT);
        } else {
            moveSlider(expectedSliderValue, Keys.ARROW_LEFT);
        }
        Assert.assertEquals(getSliderValue(), expectedSliderValue);
    }

    public void moveSlider(int expectedSliderValue, Keys key) {
        while (getSliderValue() != expectedSliderValue) {
            driver.findElement(By.cssSelector(".range-slider")).sendKeys(key);
        }
    }

    public int getSliderValue() {
        String sliderValue = driver.findElement(By.cssSelector("#sliderValue"))
                .getAttribute("value");
        return Integer.parseInt(sliderValue);
    }
}
