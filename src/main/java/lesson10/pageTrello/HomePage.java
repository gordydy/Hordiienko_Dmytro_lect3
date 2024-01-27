package lesson10.pageTrello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public SelenideElement boardTitle = $(".board-tile-details-name");
    public SelenideElement dashboardTitle = $("[data-testid='board-name-display']");

    public String dashboardRedirect(){
        String nameTitle = boardTitle. shouldBe(Condition.visible).shouldHave().text();
        boardTitle.click();
        dashboardTitle.shouldBe(Condition.visible);
        return nameTitle;
    }

    public void assertIsOpened(String nameTitle){
        String nameDashboard = dashboardTitle.shouldHave().text();
        Assert.assertEquals(nameDashboard, nameTitle, "Titles isn't equals" );
    }
}
