package lesson13.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    private String url;

    private SelenideElement usernameField = $("#user-name");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $("#login-button");

    public void login(String username, String password) {
        usernameField.shouldBe(Condition.editable).setValue(username);
        passwordField.shouldBe(Condition.editable).setValue(password);
        loginButton.shouldBe(Condition.visible).click();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html", "Login failed");
    }
}
