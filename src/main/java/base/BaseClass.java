package base;

import com.microsoft.playwright.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static Dotenv dotenv;

    @BeforeMethod
    public void setup() {
        dotenv = Dotenv.load();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate(dotenv.get("BASE_URL"));
    }

    @AfterMethod
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}