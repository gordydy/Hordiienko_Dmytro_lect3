package lesson13;

import com.codeborne.selenide.WebDriverRunner;
import lesson13.config.Browser;
import lesson13.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SaucedemoTest {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String CART_URL = "https://www.saucedemo.com/cart.html";
    private String url;

    private final String username = "standard_user";
    private final String password = "secret_sauce";
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    OverviewPage overviewPage = new OverviewPage();
    OrderCompletePage orderCompletePage = new OrderCompletePage();
    FinishPage finishPage = new FinishPage();

    @BeforeTest
    public void beforeTest() {
        Browser.setBrowser();
    }


    @Test(priority = 1)
    public void loginStep() {
        open(BASE_URL);
        loginPage.login(username, password);
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 2)
    public void addToCardStep() {
        open(url);
        mainPage.addItemsToCart();
    }

    @Test(priority = 3)
    public void checkCartItemsStep() {
        open(CART_URL);
        cartPage.assertItems();
        cartPage.assertCheckout();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 4)
    public void overviewPageStep() {
        open(url);
        overviewPage.fillPersonalData();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 5)
    public void compliteOrderStep() {
        open(url);
        orderCompletePage.evaluateTaxPercent();
        orderCompletePage.assertFinish();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 6)
    public void finishMessageStep() {
        open(url);
        finishPage.assertFinnishMessage();
    }

}
