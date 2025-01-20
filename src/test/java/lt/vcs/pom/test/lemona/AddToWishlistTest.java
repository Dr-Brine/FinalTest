package lt.vcs.pom.test.lemona;

import lt.vcs.pom.page.lemona.AddToWishlistPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToWishlistTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        AddToWishlistPage.open("https://www.lemona.lt/");
    }

    @DataProvider(name = "dataProviderAddSelectedItemToWishlist", parallel = true)
    public Object[][] provideDataForAddSelectedItemToWishlist() {
        return new Object[][]{
                {"organim217@gmail.com", "Organijus1+"}
        };
    }

    @Test(dataProvider = "dataProviderAddSelectedItemToWishlist")
    public void testAddSelectedItemToWishlist(String email, String password) {
        String expectedResult = "CR2032/PAN";
        String actualResult;

        AddToWishlistPage.clickButtonAcceptAllCookies();
        AddToWishlistPage.clickLogInButton();
        AddToWishlistPage.enterValidEmail(email);
        AddToWishlistPage.enterValidPassword(password);
        AddToWishlistPage.pressButtonLogIn();
        AddToWishlistPage.clickHamburgerMenu();
        AddToWishlistPage.clickSideMenuELement();
        AddToWishlistPage.clickItemCategoryTitle();
        AddToWishlistPage.clickItemCardTitle();
        AddToWishlistPage.clickCategory();
        AddToWishlistPage.clickDropDownListName();
        AddToWishlistPage.checkCategoryCheckBox();
        AddToWishlistPage.clickSortedItemCardTitle();
        AddToWishlistPage.clickAddToWishList();
        AddToWishlistPage.clickWishList();
        actualResult = AddToWishlistPage.readItemCardPageSkuName();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
