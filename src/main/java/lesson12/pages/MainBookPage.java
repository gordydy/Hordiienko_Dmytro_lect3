package lesson12.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
public class MainBookPage {
    private SelenideElement closePopUp = $(".cl-dialog-close-icon");
    private SelenideElement inputField = $(By.tagName("input"));
    private SelenideElement scrollArea = $( ".scroll-area.custom-scroll");
    private SelenideElement findButton = $(".ui-btn-primary");
    private SelenideElement titleName = $( ".category__title");
    String url;


    public void searchBook (String name) {
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        closePopUp.shouldBe().click();
        inputField.shouldBe().val(name);
        scrollArea.shouldBe(Condition.visible);
        findButton.shouldBe().click();
        String title = titleName.shouldBe(Condition.visible).text();
        Assert.assertEquals(title, "Результати пошуку «"+ name +"»");
    }
}
