package lt.vcs.pom.test.lemona;

import lt.vcs.pom.page.lemona.TextSearchPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextSearchTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        TextSearchPage.open("https://www.lemona.lt/");
    }

    @Test
    public void testTextSearchBar() {
        String itemName = "cr2032";
        String expectedResult = "CR2032/DUR/BL2";
        String actualResult;

        TextSearchPage.clickButtonAcceptAllCookies();
        TextSearchPage.enterItemName(itemName);
        TextSearchPage.clickButtonSubmit();
        TextSearchPage.clickOnSearchResultItemName();
        actualResult = TextSearchPage.readSearchResultSkuName();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
