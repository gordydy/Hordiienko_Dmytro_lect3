package lesson12.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    private SelenideElement bookTitleButton = $(".ui-card-title.category-card__name");

    public void assertBookIsFound(String name) {
        String bookName = bookTitleButton.shouldBe(Condition.visible).text();
        Assert.assertEquals(bookName, name, "No searched book is present");
    }

    public void openBook() {
        WebElement linkElement = WebDriverRunner.getWebDriver().findElement(By.cssSelector("div.category-card-content-wrapper a"));
        String href = linkElement.getAttribute("href");
        bookTitleButton.shouldBe(Condition.visible).click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, href, "no redirect");
    }

}
