package lesson13.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends MainPage {
    private ElementsCollection itemPrice = $$(".inventory_item_price");
    private SelenideElement checkoutButton = $("#checkout");

    public void assertItsCartPage() {
        String url = WebDriverRunner.url();
        Assert.assertEquals(url, "https://www.saucedemo.com/cart.html", "It's not a cart page!");
    }

    public void assertItems(String priceOne, String pciceTwo) {
        Boolean foundOne = null;
        Boolean foundTwo = null;
        for (SelenideElement selenideElement : itemPrice) {
            String priceText = selenideElement.text();
            if (priceText.equals(priceOne)) {
                Assert.assertEquals(priceText, priceOne, "Price isn't equal to " + priceOne);
                foundOne = true;
            } else if (priceText.equals(pciceTwo)) {
                Assert.assertEquals(priceText, pciceTwo, "Price isn't equal to " + pciceTwo);
                foundTwo = true;
            }
        }
        Assert.assertTrue(foundOne, priceOne + " not found");
        Assert.assertTrue(foundTwo, pciceTwo + " not found");
//
    }

    public void assertCheckout() {
        checkoutButton.shouldBe().click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html", "Redirect isn't work");

    }
}
