package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage {
    private final Page page;

    private final String usernameInputLoc = "#user-name";
    private final String passwordInputLoc = "#password";
    private final String loginButtonLoc = "#login-button";
    private final String inventoryContainerLoc = "#inventory_container.inventory_container";
    private final String error = "[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    @Step("Entering username")
    public void enterUsername(String username) {
        page.waitForSelector(usernameInputLoc).fill(username);
    }

    @Step("Entering password")
    public void enterPassword(String password) {
        page.waitForSelector(passwordInputLoc).fill(password);
    }

    @Step("Clicking login button")
    public void clickLoginButton() {
        page.waitForSelector(loginButtonLoc).click();
    }

    @Step("Verifying if inventory container is visible")
    public boolean isInventoryContainerVisible() {
        return page.locator(inventoryContainerLoc).isVisible();
    }

    @Step("Verifying if login error message is visible")
    public boolean isLoginErrorVisible() {
        return page.locator(error).isVisible();
    }
}
