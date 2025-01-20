package lt.vcs.pom.page;

import lt.vcs.pom.util.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Common {
    public static void openUrl(String url, int seconds) {
        Driver.initChromeDriver();
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
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

    public static void waitElementEnabled(By locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitElementLocated(By locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static Actions getActions() {
        return new Actions(Driver.getDriver());
    }

    public static void scrollDownToElementWithActions(By locator) {
        getActions().scrollToElement(getElement(locator)).perform();
    }
}
