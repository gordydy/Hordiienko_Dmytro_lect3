package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private ElementsCollection price = $$(".pricebar");
    private SelenideElement cartValueBadge = $(".shopping_cart_badge");


    public void addItemsToCart() {
        for (int i = 0; i < price.size(); i++) {
            String itemPrice = price.get(i).find(".inventory_item_price").getText();
            if (itemPrice.equals("$7.99") || itemPrice.equals("$9.99")) {
                String id = price.get(i).find(".btn_inventory").getAttribute("id");
                $(By.id(id)).click();
            }
        }
        Assert.assertEquals(cartValueBadge.shouldBe(Condition.visible).getText(), "2", "Card is empty");

    }

}

