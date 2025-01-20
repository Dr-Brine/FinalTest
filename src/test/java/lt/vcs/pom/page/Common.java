package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static void openUrl(String url, int seconds) {
        Driver.initChromeDriver();
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void openUrl(String url) {
        Driver.initChromeDriver();
        Driver.getDriver().get(url);
    }

    public static void quitDriver() {
        Driver.getDriver().quit();
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static void repeatClickOnElement(By locator, By locatorToCheck, int seconds) throws InterruptedException {

        for (int i = 0; i < seconds * 2; i++) {

            try {
                scrollDownToElementWithActions(locator);
                getElement(locator).click();
                getElement(locatorToCheck).isDisplayed();
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(500);
            }
        }

    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static boolean isElementVisible(By locator) {
        return getElement(locator).isDisplayed();
    }

    public static void waitElementEnabled(By locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitElementLocated(By locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPageLoadAndAjaxComplete(int seconds) throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        Thread.sleep(250);

        webDriverWait.until(
                driver -> {
                    // Tikrina puslapio būklę ir aktyvias užklausas
                    String readyState = (String) getJSExecutor().executeScript("return document.readyState");
                    Boolean ajaxComplete = (Boolean) getJSExecutor().executeScript(
                            "return (typeof jQuery !== 'undefined' ? jQuery.active == 0 : true) && " +
                                    "!(window.fetch && window.__pendingFetchCount > 0);"
                    );
                    return "complete".equals(readyState) && ajaxComplete;
                }
        );

    }

    public static String getElementAttributeValue(By locator, String attribute) {
        return getElement(locator).getDomAttribute(attribute);
    }

    public static void waitElementAttributeChange(By locator, int seconds, String attribute, String value) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    private static Actions getActions() {
        return new Actions(Driver.getDriver());
    }

    public static void scrollDownWithActions() {
        getActions().sendKeys(Keys.PAGE_DOWN).perform();
    }

    public static void scrollDownToElementWithActions(By locator) {
        getActions().scrollToElement(getElement(locator)).perform();
    }

    public static void scrollByAmountWithActions(int x, int y) {
        getActions().scrollByAmount(x, y).perform();
    }

    public static void doubleClickOnElementByActions(By locator) {
        getActions().doubleClick(getElement(locator)).perform();
    }

    public static void rightClickOnElementByActions(By locator) {
        getActions().contextClick(getElement(locator)).perform();
    }

    private static JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) Driver.getDriver();
    }

    public static void scrollDownToElementWithJS(By locator) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public static void scrollByAmountWithJS(int x, int y) {
        getJSExecutor().executeScript("window.scrollBy(%s, %s);".formatted(x, y));
    }


    public static void selectOptionByValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    public static List<Boolean> getListOfSelectedElementGroup(By locator) {
        List<WebElement> elements = getElements(locator);
        List<Boolean> statuses = new ArrayList<>();

        for (WebElement element : elements) {
            statuses.add(element.isSelected());
        }

        return null;
    }
}
