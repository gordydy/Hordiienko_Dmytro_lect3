package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private final String firstName = "Valeriy";
    private final String lastName = "Zhmyshenko";
    private final String postalCode = "12345";

    private SelenideElement firstNameField = $("#first-name");

    private SelenideElement lastNameField = $("#last-name");

    private SelenideElement postalCodeField = $("#postal-code");


    private SelenideElement continueButton = $("#continue");


    public void fillPersonalData() {
        firstNameField.shouldBe(Condition.visible).shouldBe(Condition.editable).val(firstName);
        String firstNameval = firstNameField.getAttribute("value");
        Assert.assertEquals(firstNameval, firstName, "The first name isn't equals");

        lastNameField.shouldBe(Condition.visible).shouldBe().val(lastName);
        String lastNameVal = lastNameField.getAttribute("value");
        Assert.assertEquals(lastNameVal, lastName, "The last name isn't equals");

        postalCodeField.shouldBe(Condition.visible).shouldBe(Condition.editable).val(postalCode);
        String postalCodeVal = postalCodeField.getAttribute("value");
        Assert.assertEquals(postalCodeVal, postalCode, "The postal code isn't equals");

        continueButton.shouldBe(Condition.visible).shouldBe().click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-two.html", "Redirect to the step two failed");


    }


}
