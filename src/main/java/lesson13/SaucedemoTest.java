package lesson13;

import lesson13.config.Browser;
import lesson13.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SaucedemoTest {
    public static final String BASE_URL = "https://www.saucedemo.com/";

    private final String username = "standard_user";
    private final String password = "secret_sauce";
    private final String firstName = "Valeriy";
    private final String lastName = "Zhmyshenko";
    private final String postalCode = "12345";
    private String priceOne = "$7.99";
    private String priceTwo = "$9.99";
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    OverviewPage overviewPage = new OverviewPage();
    OrderCompletePage orderCompletePage = new OrderCompletePage();
    FinishPage finishPage = new FinishPage();

    @BeforeMethod
    public void beforeMethod() {
        Browser.setBrowser();
    }

    @Test
    public void login() {
        open(BASE_URL);
        loginPage.login(username, password);
    }

    @Test
    public void addToCard() {
        login();
        mainPage.addItemsToCart(priceOne, priceTwo);
    }

    @Test
    public void checkCartItems() {
        addToCard();
        cartPage.assertItsCartPage();
        cartPage.assertItems();
        cartPage.assertCheckout();
    }

    @Test
    public void fillPersonalData() {
        checkCartItems();
        overviewPage.fillFirstName(firstName);
        overviewPage.fillLastName(lastName);
        overviewPage.fillPostalCode(postalCode);
        overviewPage.continueForward();
    }

    @Test
    public void compliteOrder() {
        fillPersonalData();
        orderCompletePage.evaluateTaxPercent();
        orderCompletePage.assertFinish();
        finishPage.assertFinnishMessage();
    }
}
