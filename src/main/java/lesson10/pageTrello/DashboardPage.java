package lesson10.pageTrello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage extends CardEditorPage {
    protected String cardNameVal = "My test Card";

    private SelenideElement addCardButton = $("[data-testid='list-add-card-button']");
    private SelenideElement addCardTitleField = $("[data-testid='list-card-composer-textarea']");
    private SelenideElement saveCardButton = $("[data-testid='list-card-composer-add-card-button']");

    private SelenideElement cardName = $$("[data-testid='card-name']").last();


    public void createCard() {
        addCardButton.shouldBe(Condition.visible).click();
        addCardTitleField.shouldBe(Condition.visible).setValue(cardNameVal);
        saveCardButton.shouldBe().click();
    }

    public void assertIsCardCreated() {
        Assert.assertEquals(cardName.shouldBe(Condition.visible).shouldHave().text(), cardNameVal, "Card isn't created");

    }
    public void assertCardIsNotExist()  {
        try {
        Object name = cardName.getText();
        Assert.assertNotEquals(name, cardNameVal, "Card isn't deleted: ");
        System.out.println("Last card on the board: " + name);
        } catch (IndexOutOfBoundsException e){
            System.out.println("No any cards on the board. Caught exception: " + e.getMessage());
        }

    }
    public void openCard(){
        cardName.shouldBe(Condition.visible).click();
    }
}
