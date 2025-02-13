package tests;

import base.BaseClass;
import controllers.LoginController;
import io.qameta.allure.Description;
import org.testng.annotations.*;

public class LoginTest extends BaseClass {

    private LoginController loginController;

    /* Initializes the controller before test case execution */
    @BeforeMethod
    public void setupController() {
        loginController = new LoginController(page);
    }

    @Test
    @Description("Verify that the user is successfully logged in")
    public void testValidLogin() {
        loginController.login(dotenv.get("VALID_USERNAME"), dotenv.get("VALID_PASSWORD"));
        loginController.verifyLogin();
    }

    @Test
    @Description("Verify that the user cannot log in with incorrect credentials")
    public void testInvalidLogin() {
        loginController.login(dotenv.get("INVALID_USERNAME"), dotenv.get("INVALID_PASSWORD"));
        loginController.verifyLoginFailure();
    }

}
