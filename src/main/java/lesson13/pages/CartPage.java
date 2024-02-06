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

   public void assertItsCartPage(){
       String url = WebDriverRunner.url();
       Assert.assertEquals(url, "https://www.saucedemo.com/cart.html", "It's not a cart page!");
   }
    public void assertItems() {
        Boolean found799 = null;
        Boolean found999 = null;
        for (int i = 0; i < itemPrice.size(); i++) {
            String priceText = itemPrice.get(i).text();
            if (priceText.equals("$7.99")) {
                Assert.assertEquals(priceText, "$7.99", "Price isn't equal to $7.99 ");
                found799 = true;
            } else if (priceText.equals("$9.99")) {
                Assert.assertEquals(priceText, "$9.99", "Price isn't equal to $9.99");
                found999 = true;
            }
        }
        Assert.assertTrue(found799, "$7.99 not found");
        Assert.assertTrue(found999, "$9.99 not found");
//
    }

    public void assertCheckout() {
        checkoutButton.shouldBe().click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html", "Redirect isn't work");

    }
}
