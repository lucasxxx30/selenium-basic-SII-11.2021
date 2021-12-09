import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void shouldPass() {
        System.out.println("I will pass");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void shouldFail() {
        System.out.println("I will fail");
        Assert.assertEquals(1, 2);
    }

    @BeforeMethod
    public void setup() {
        System.out.println("I will be executed before each test");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("I will be executed after each test");
    }
}
