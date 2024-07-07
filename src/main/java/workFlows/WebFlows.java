package workFlows;

import Extensions.UiActions;
import io.qameta.allure.Step;
import pageObjects.LoginPage;
import utilities.Base;

public class WebFlows extends Base {

    @Step("Get Total Products")
    public static int getTotalProducts() {
        return UiActions.getListTotal(homePage.inventoryTitles);
    }

    @Step("Print Products")
    public static void printTotalProducts() {
        System.out.println("Products: ");
        UiActions.printListContent(homePage.inventoryTitles);
    }

    @Step("Check if Product Exists")
    public static boolean isExist(String product) {
        return UiActions.searchForItem(homePage.inventoryTitles, product);
    }

    @Step("Navigate to Product by Index")
    public static void navigateToProductByIndex(int index) {
        UiActions.clickItemByIndex(homePage.inventoryPictures, index);
    }

    @Step("Navigate to Product by Index")
    public static void navigateToProductByIndex(String index) {
        UiActions.clickItemByIndex(homePage.inventoryPictures, Integer.parseInt(index));
    }

    @Step("Sign in using provided {userName} and {password}")
    public static void signIn(String userName, String password) {
        UiActions.click(LoginPage.userNameField);
        UiActions.updateText(LoginPage.userNameField, userName);
        UiActions.click(LoginPage.passwordField);
        UiActions.updateText(LoginPage.passwordField, password);
        UiActions.click(loginPage.submitButton);
    }

    @Step("Get Product Title")
    public static String getProductTitle() {
        String title = UiActions.getElementContent(itemPage.productTitle);
        System.out.println("Product Title: " + title);
        return title;
    }

    @Step("Go List")
    public static void goList() {
        UiActions.navigateToUrl(getDataFromXml("LIST_URL"));
    }

    @Step("Get Button Text")
    public static String getButtonText() {
        String getButtonText = UiActions.getElementContent(itemPage.backToProductsButton);
        System.out.println("Accessed Item Page Successfully. Found Item Page Button: " + "\"" + getButtonText +"\"");
        return getButtonText;

    }
}
