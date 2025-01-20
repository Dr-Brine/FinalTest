package lt.vcs.pom.page.lemona;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class LogInPage {
    private static final By buttonAcceptAllCookies =
            By.xpath("//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary ch2-btn-text-sm']");
    private static final By buttonLogIn =
            By.xpath("//button[@aria-label='Prisijungti']");
    private static final By inputEmail =
            By.xpath("//div[@role='dialog' and contains(@class, 'customer-modal-login-wrapper') and " +
                    "@style='display: block;']//input[@name='email' and @placeholder='Įveskite savo el. paštą']");
    private static final By inputPassword =
            By.xpath("//div[@role=\"dialog\" and contains(@class, \"customer-modal-login-wrapper\")]" +
                    "//input[@name=\"email\" and " + "@type=\"text\" and contains(@placeholder, " +
                    "\"Įveskite savo el. paštą\")]" +
                    "/following::input[@type=\"password\" and contains(@placeholder, \"Įveskite slaptažodį\")]");
    private static final By buttonSubmit =
            By.xpath("//div[@role=\"dialog\" and contains(@class, \"customer-modal-login-wrapper\")]" +
                    "//input[@name=\"email\" and @type=\"text\" and contains(@placeholder, " +
                    "\"Įveskite savo el. paštą\")]/following::input[@type=\"password\" and contains(@placeholder, " +
                    "\"Įveskite slaptažodį\")]/following::button[@type=\"submit\" and contains(@class, " +
                    "\"login-form-login-btn\")]");
    private static final By textCustomerTitleLinkButton =
            By.xpath("//div[contains(@class, \"RightBlock-rightBlock-1vn\")]//a[contains(@class, " +
                    "\"CustomerTitle-linkButton\") and @href=\"/customer/account\"]//span[text()=\"Organijus Gymas\"]");

    public static void open(String url) {
        Common.openUrl(url, 8);
    }

    public static void clickButtonAcceptAllCookies() {
        Common.waitElementEnabled(buttonAcceptAllCookies, 2);
        Common.clickOnElement(buttonAcceptAllCookies);
    }

    public static void clickLogInButton() {
        Common.clickOnElement(buttonLogIn);
    }

    public static void enterValidEmail(String email) {
        Common.sendKeysToElement(inputEmail, email);
    }

    public static void enterValidPassword(String password) {
        Common.sendKeysToElement(inputPassword, password);
    }

    public static void pressButtonLogIn() {
        Common.clickOnElement(buttonSubmit);
    }

    public static String readCustomerTitleLinkButton() {
        Common.waitElementEnabled(textCustomerTitleLinkButton, 2);
        return Common.getTextFromElement(textCustomerTitleLinkButton);
    }
}
