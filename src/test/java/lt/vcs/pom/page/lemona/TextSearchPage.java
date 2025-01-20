package lt.vcs.pom.page.lemona;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class TextSearchPage {
    private static final By buttonAcceptAllCookies =
            By.xpath("//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary ch2-btn-text-sm']");
    private static final By inputItemName =
            By.xpath("//input[@name='searchText']");
    private static final By buttonSearchSubmit =
            By.xpath("//button[@type='submit' and @class='SearchBar-searchButton-1u0']");
    private static final By productCardSkuName =
            By.xpath("//div[@class='ProductCard-sku-1xM' and text()='CR2032/DUR/BL2']");
    private static final By skuBlockCode =
            By.xpath("//span[@class='sku-block-code' and text()='CR2032/DUR/BL2']");

    public static void open(String url) {
        Common.openUrl(url, 8);
    }

    public static void clickButtonAcceptAllCookies() {
        Common.waitElementEnabled(buttonAcceptAllCookies, 2);
        Common.clickOnElement(buttonAcceptAllCookies);
    }

    public static void enterItemName(String itemName) {
        Common.sendKeysToElement(inputItemName, itemName);
    }

    public static void clickButtonSubmit() {
        Common.clickOnElement(buttonSearchSubmit);
    }

    public static void clickOnSearchResultItemName() {
        Common.waitElementLocated(productCardSkuName, 5);
        Common.clickOnElement(productCardSkuName);
    }

    public static String readSearchResultSkuName() {
        return Common.getTextFromElement(skuBlockCode);
    }
}
