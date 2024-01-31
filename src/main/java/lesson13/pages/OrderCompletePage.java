package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import java.text.DecimalFormat;

import static com.codeborne.selenide.Selenide.$;

public class OrderCompletePage {
    private SelenideElement priceWithoutTax = $(".summary_subtotal_label");
    private SelenideElement summaryTax = $(".summary_tax_label");
    private SelenideElement finishButton = $("#finish");

    public void evaluateTaxPercent() {
        String priceWithText = priceWithoutTax.shouldBe(Condition.visible).text();
        String TaxWithText = summaryTax.shouldBe(Condition.visible).text();
        int dollarIndexPrice = priceWithText.indexOf('$');
        int dollarIndexTax = TaxWithText.indexOf('$');
        if (dollarIndexPrice != -1 && dollarIndexTax != -1) {
            Double priceWithoutText = Double.parseDouble(priceWithText.substring(dollarIndexPrice + 1));
            Double priceWithoutTax = Double.parseDouble(TaxWithText.substring(dollarIndexTax + 1));

            Double taxPercent = ((priceWithoutTax / priceWithoutText) * 100);
            DecimalFormat df = new DecimalFormat("#.##");
            String formattedValue = df.format(taxPercent);
            System.out.println("Tax percent = " + formattedValue + "%");
        }
    }

    public void assertFinish() {
        finishButton.shouldBe(Condition.visible).click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html", "Redirect failed");
    }

}