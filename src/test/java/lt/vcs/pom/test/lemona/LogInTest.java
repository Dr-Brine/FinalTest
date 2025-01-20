package lt.vcs.pom.test.lemona;

import lt.vcs.pom.page.lemona.LogInPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        LogInPage.open("https://www.lemona.lt/");
    }

    @DataProvider(name = "dataProviderLogInWithValidCredentials", parallel = true)
    public Object[][] provideDataForLogInWithValidCredentials() {
        return new Object[][]{
                    {"organim217@gmail.com", "Organijus1+", "ORGANIJUS GYMAS"}
        };
    }

    @Test(dataProvider = "dataProviderLogInWithValidCredentials")
    public void testLogInWithValidCredentials(String email, String password, String expectedResult) {
        String actualResult;

        LogInPage.clickButtonAcceptAllCookies();
        LogInPage.clickLogInButton();
        LogInPage.enterValidEmail(email);
        LogInPage.enterValidPassword(password);
        LogInPage.pressButtonLogIn();
        actualResult = LogInPage.readCustomerTitleLinkButton();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
