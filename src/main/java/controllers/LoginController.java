package controllers;

import com.microsoft.playwright.Page;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginController {
    private final LoginPage loginPage;

    public LoginController(Page page) {
        this.loginPage = new LoginPage(page);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void verifyLogin() {
        assertTrue(loginPage.isInventoryContainerVisible(), "User login failed with Correct user credentials");
    }

    public void verifyLoginFailure() {
        assertTrue(loginPage.isLoginErrorVisible(), "Error message not displayed for invalid login.");
    }
}
