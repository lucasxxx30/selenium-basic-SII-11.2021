import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.RegistrationPage;
import pages.SignInPage;

public class FormPopTest extends TestBase {

    @BeforeMethod
    public void testSetup() {
        driver.get("http://146.59.32.4/");
    }

    @Test
    public void shouldFillFormWithSuccess() {
        new MenuPage(driver).goToSignIn();

        new SignInPage(driver).goToRegistration();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setName("Jan");
        registrationPage.selectMale();
        registrationPage.setPassword("password");
        registrationPage.setEmail(RandomStringUtils.randomAlphabetic(10) + "@wp.pl");
        registrationPage.setLastName("Kowalski");
        registrationPage.acceptGdpr();
        registrationPage.acceptPolicy();
        registrationPage.signUpUser();

        String actualName = new MenuPage(driver).getLoggedUserName();
        Assert.assertEquals(actualName, "Jan Kowalski");
    }

    @Test
    public void shouldFillFormWithSuccessFPOP() {
        new MenuPage(driver)
                .goToSignIn()
                .goToRegistration()
                .setName("Jan")
                .selectMale()
                .setPassword("password")
                .setEmail(RandomStringUtils.randomAlphabetic(10) + "@wp.pl")
                .setLastName("Kowalski")
                .acceptGdpr()
                .acceptPolicy()
                .signUpUser();

        String actualName = new MenuPage(driver).getLoggedUserName();
        Assert.assertEquals(actualName, "Jan Kowalski");
    }

    public void shouldFillFormWithSuccessFPOP2() {
        Assert.assertEquals(
                new MenuPage(driver)
                        .goToSignIn()
                        .goToRegistration()
                        .setName("Jan")
                        .selectMale()
                        .setPassword("password")
                        .setEmail(RandomStringUtils.randomAlphabetic(10) + "@wp.pl")
                        .setLastName("Kowalski")
                        .acceptGdpr()
                        .acceptPolicy()
                        .signUpUser()
                        .getLoggedUserName(), "Jan Kowalski");
    }

    public void shouldFillFormWithSuccessFPOP3() {
        new MenuPage(driver)
                .goToSignIn();

        new SignInPage(driver)
                .goToRegistration();

        new RegistrationPage(driver)
                .setName("Jan")
                .selectMale()
                .setPassword("password")
                .setEmail(RandomStringUtils.randomAlphabetic(10) + "@wp.pl")
                .setLastName("Kowalski")
                .acceptGdpr()
                .acceptPolicy()
                .signUpUser();

        Assert.assertEquals(new MenuPage(driver).getLoggedUserName(),
                "Jan Kowalski");
    }
}
