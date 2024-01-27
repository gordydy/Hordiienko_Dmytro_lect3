package lesson10.pageTrello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;


public  class LoginPage {
    public String username = "dmytro.hordiienko@appflame.com";
    public String password = "qwerty123qwerty321";
private final SelenideElement loginPageButton = $("[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
private SelenideElement usernameField = $("[id='username']");
private SelenideElement passwordField = $("[id = 'password']");
private SelenideElement loginSubmitButton = $("[id='login-submit']");
private SelenideElement userPhoto = $(".DweEFaF5owOe02.V_PnoJ2AynVwLp.G6CmOLx93OUZez");


public void clickLoginButton (){
    loginPageButton.shouldBe(Condition.visible);
    loginPageButton.click();
}
public void authorization (String username, String password){
    usernameField.shouldBe(Condition.visible);
    usernameField.setValue(username).pressEnter();
    passwordField.setValue(password).pressEnter();
    loginSubmitButton.shouldBe(Condition.visible);
    loginSubmitButton.click();
}
public void assertIsOpen (){
        userPhoto.shouldBe(Condition.visible);
    }


}

