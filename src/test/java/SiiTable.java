import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SiiTable extends TestBase {

    @Test
    public void shouldPrintPeaksOver4000m() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(rows.size() > 0);
        for (WebElement row : rows){
            int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());
            if(height >4000){
                List<WebElement> cells = row.findElements(By.cssSelector("td"));
                System.out.println(cells.get(0).getText());
            }

        }
    }
}
