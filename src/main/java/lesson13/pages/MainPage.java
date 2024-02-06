package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private ElementsCollection price = $$(".pricebar");
    private SelenideElement cartValueBadge = $(".shopping_cart_badge");
    private SelenideElement cartButton = $(".shopping_cart_link");



    public void addItemsToCart(String priceOne, String priceTwo) {
        for (SelenideElement selenideElement : price) {
            String itemPrice = selenideElement.find(".inventory_item_price").getText();
            if (itemPrice.equals(priceOne) || itemPrice.equals(priceTwo)) {
                String id = selenideElement.find(".btn_inventory").getAttribute("id");
                $(By.id(id)).click();
            }
        }
        Assert.assertEquals(cartValueBadge.shouldBe(Condition.visible).getText(), "2", "Card is empty");
        cartButton.shouldBe(Condition.visible).click();
    }

}

