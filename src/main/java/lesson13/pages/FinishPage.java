package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class FinishPage {
    private SelenideElement finishTitle = $(".complete-header");

    public void assertFinnishMessage() {
        String message = finishTitle.shouldBe(Condition.visible).text();
        Assert.assertEquals(message, "Thank you for your order!", "Order failed");
    }
}
