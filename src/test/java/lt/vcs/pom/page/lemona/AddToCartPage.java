package lt.vcs.pom.page.lemona;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

public class AddToCartPage {
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
    private static final By listMegamenuContainer =
            By.xpath("//li[@class='megamenu-container first-container']");
    private static final By menuSecondLevelLinkBaterijosIrELementai =
            By.xpath("//a[@class='menu-second-level-link' and text()='Baterijos ir elementai']");
    private static final By categoryCardTitleIvairiosBaterijos =
            By.xpath("//span[@class='CategoryCard-title-1vj' " +
                    "and text()='Įvairios baterijos (neįkraunami elementai)']");
    private static final By categoryCardTitleDiskinesBaterijos =
            By.xpath("//span[@class='CategoryCard-title-1vj' and text()='Diskinės baterijos']");
    private static final By categoryCardTitleNeikraunamosDiskinesBaterijos =
            By.xpath("//span[@class='CategoryCard-title-1vj' and " +
                    "text()='Neįkraunamos diskinės baterijos']");
    private static final By buttonNameLinkRodytiDaugiau =
            By.xpath("(//button[@class='btn btn-link']//span[text()='Rodyti daugiau'])[1]");
    private static final By inputCheckBoxCr2032 =
            By.xpath("//input[@id='desk-ep_string_1796-CR2032']");
    private static final By productCardSkuCr2032 =
            By.xpath("//div[@class='ProductCard-sku-1xM' and text()='CR2032/PAN']");
    private static final By buttonAddToShoppingCart =
            By.xpath("//button[@class='btn-with-icon btn-add-cart btn btn-success']");
    private static final By paragrapAddToCartSuccessMessage =
            By.xpath("//div[@class='AddToCartSuccessDialog-successMessage-3h5']");

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

    public static void clickHamburgerMenu() {
        Common.waitElementEnabled(listMegamenuContainer, 5);
        Common.clickOnElement(listMegamenuContainer);
    }

    public static void clickSideMenuELement() {
        Common.clickOnElement(menuSecondLevelLinkBaterijosIrELementai);
    }

    public static void clickItemCategoryTitle() {
        Common.clickOnElement(categoryCardTitleIvairiosBaterijos);
    }

    public static void clickItemCardTitle() {
        Common.clickOnElement(categoryCardTitleDiskinesBaterijos);
    }

    public static void clickCategory() {
        Common.clickOnElement(categoryCardTitleNeikraunamosDiskinesBaterijos);
    }

    public static void clickDropDownListName() {
        Common.scrollDownToElementWithActions(buttonNameLinkRodytiDaugiau);
        Common.clickOnElement(buttonNameLinkRodytiDaugiau);
    }

    public static void checkCategoryCheckBox() {
        Common.scrollDownToElementWithActions(inputCheckBoxCr2032);
        Common.clickOnElement(inputCheckBoxCr2032);
    }

    public static void clickSortedItemCardTitle() {
        Common.waitElementEnabled(productCardSkuCr2032, 2);
        Common.clickOnElement(productCardSkuCr2032);
    }

    public static void clickAddToShoppingCart() {
        Common.clickOnElement(buttonAddToShoppingCart);
    }

    public static String readAddToCartSuccessMessage() {
        return Common.getTextFromElement(paragrapAddToCartSuccessMessage);
    }
}
