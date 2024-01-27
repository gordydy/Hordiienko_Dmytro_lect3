package lesson10.testTrello;

import com.codeborne.selenide.WebDriverRunner;
import lesson10.config.Browser;
import lesson10.pageTrello.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


/*
        Логінитись +
        Переходити в дашборд (Тест на перевірку переходу) +
        Створювати задачу (картку) +
        Додавати опис до картки+
        Додавати коментар до картки +
        Тест має видаляти створену картку за собою. +
        Тести мають виконуватись у правильному порядку, та залежати один від одного (Якщо тест на створення картки впав, тест на додавання опису має бути пропущений)
*/
public class TestTrello extends LoginPage {

    private String url;
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final CardEditorPage addDescription = new CardEditorPage();
    private final CardEditorPage addComment = new CardEditorPage();
    private final CardEditorPage deleteCard = new CardEditorPage();



    @BeforeTest
    public void beforeMethod() {
        Browser.setBrowser();
    }

    @Test(priority = 1)
    public void trelloLogin() {

        /*Login*/

        open("https://trello.com");
        loginPage.clickLoginButton();
        loginPage.authorization(username,password);
        loginPage.assertIsOpen();

        /*Dashboard redirect*/

        String nameTitle = homePage.dashboardRedirect();
        homePage.assertIsOpened(nameTitle);
        url = WebDriverRunner.currentFrameUrl();
    }

    @Test (priority = 2)
    public void addCard (){
        open(url);
        dashboardPage.createCard();
        dashboardPage.assertIsCardCreated();
        url = WebDriverRunner.currentFrameUrl();
    }
    @Test (priority = 3, dependsOnMethods = "addCard")
    public void addDescription (){
        open(url);
        dashboardPage.openCard();
        addDescription.assertCardViewIsOpened();
        addDescription.createDescription();
        addDescription.assertDescriptionIsCreated();
        url = WebDriverRunner.currentFrameUrl();
    }
    @Test (priority = 5, dependsOnMethods = "addCard")
    public void addComment (){
        open(url);
        addComment.createComment();
        addComment.assertCommentIsCreated();
        url = WebDriverRunner.currentFrameUrl();

    }
    @Test (priority = 6, dependsOnMethods = "addCard")
    public void cardDelete (){
        open(url);
        deleteCard.deleteCard();
        String currentUrl = WebDriverRunner.currentFrameUrl();
        refresh();
        url = WebDriverRunner.currentFrameUrl();
        Assert.assertEquals(currentUrl, url, "url is not equals");
        dashboardPage.assertCardIsNotExist();
    }
}
