package lt.vcs.pom.test.lemona;

import lt.vcs.pom.page.lemona.MenuNavigationPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuNavigationTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        MenuNavigationPage.open("https://www.lemona.lt/");
    }

    @Test
    public void testSideMenuNavigation() {
        String expectedResult = "CR2032/PAN";
        String actualResult;

        MenuNavigationPage.clickButtonAcceptAllCookies();
        MenuNavigationPage.clickSideMenuELement();
        MenuNavigationPage.clickItemCategoryTitle();
        MenuNavigationPage.clickItemCardTitle();
        MenuNavigationPage.clickCategory();
        MenuNavigationPage.clickDropDownListName();
        MenuNavigationPage.checkCategoryCheckBox();
        MenuNavigationPage.clickSortedItemCardTitle();
        actualResult = MenuNavigationPage.readItemCardPageSkuName();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
