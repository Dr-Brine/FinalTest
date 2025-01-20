package lt.vcs.pom.test.lemona;

import lt.vcs.pom.page.lemona.AddToCartPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        AddToCartPage.open("https://www.lemona.lt/");
    }

    @DataProvider(name = "dataProviderAddSelectedItemToShoppingCart", parallel = true)
    public Object[][] provideDataForAddSelectedItemToShoppingCart() {
        return new Object[][]{
                {"organim217@gmail.com", "Organijus1+"}
        };
    }

    @Test(dataProvider = "dataProviderAddSelectedItemToShoppingCart")
    public void testAddSelectedItemToShoppingCart(String email, String password) {
        String expectedResult = "Prekė įdėta į krepšelį";
        String actualResult;

        AddToCartPage.clickButtonAcceptAllCookies();
        AddToCartPage.clickLogInButton();
        AddToCartPage.enterValidEmail(email);
        AddToCartPage.enterValidPassword(password);
        AddToCartPage.pressButtonLogIn();
        AddToCartPage.clickHamburgerMenu();
        AddToCartPage.clickSideMenuELement();
        AddToCartPage.clickItemCategoryTitle();
        AddToCartPage.clickItemCardTitle();
        AddToCartPage.clickCategory();
        AddToCartPage.clickDropDownListName();
        AddToCartPage.checkCategoryCheckBox();
        AddToCartPage.clickSortedItemCardTitle();
        AddToCartPage.clickAddToShoppingCart();
        actualResult = AddToCartPage.readAddToCartSuccessMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
