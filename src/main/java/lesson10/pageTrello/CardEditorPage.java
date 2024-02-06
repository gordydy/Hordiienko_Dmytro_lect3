package lesson10.pageTrello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CardEditorPage {
    protected String description = "My test description";
    protected String comment = "My test comment";
    private SelenideElement cardEditView = $(".card-detail-window.u-clearfix");
    private SelenideElement clickedDescriptionField = $(".ua-firefox.ProseMirror");
    private SelenideElement saveButton = $(".confirm.js-save-edit.bxgKMAm3lq5BpA.SdamsUKjxSBwGb.SEj5vUdI3VvxDc");
    private SelenideElement descriptionCreated = $(".current.markeddown.hide-on-edit.js-desc.js-show-with-desc");


    /*comment locators*/
    private SelenideElement defaultCommentField = $("[data-testid='card-back-new-comment-input-skeleton']");
    private SelenideElement clickedCommentField = $$(".ua-firefox.ProseMirror").last();
    private SelenideElement commentSaveButton = $("[data-testid='card-back-comment-save-button']");
    private SelenideElement createdComment = $(".current-comment.js-friendly-links.js-open-card");

    /*archive locators*/
    private SelenideElement archiveButton = $(".button-link.js-archive-card");
    private SelenideElement deleteButton = $(".button-link.js-delete-card.negate");
    private SelenideElement confirmDeleteButton = $(".js-confirm.full.nch-button.nch-button--danger");


    /*Description*/
    public void assertCardViewIsOpened() {
        cardEditView.shouldBe(Condition.visible);
    }

    public void createDescription() {
        clickedDescriptionField.shouldBe(Condition.visible).click();
        clickedDescriptionField.setValue(description);
        saveButton.shouldBe(Condition.visible).click();
    }

    public void assertDescriptionIsCreated() {
        Assert.assertEquals(descriptionCreated.shouldBe(Condition.visible).getText(), description, "Description isn't created");

    }

    /*Comment*/

    public void createComment() {
        defaultCommentField.shouldBe(Condition.visible).click();
        clickedCommentField.shouldBe(Condition.visible).click();
        clickedCommentField.setValue(comment);
        commentSaveButton.shouldBe().click();
    }

    public void assertCommentIsCreated() {
        Assert.assertEquals(createdComment.shouldBe(Condition.visible).getText(), comment, "Description isn't created");
    }

    public void deleteCard() {
        archiveButton.shouldBe(Condition.visible).click();
        deleteButton.shouldBe(Condition.visible).shouldBe().click();
        confirmDeleteButton.shouldBe(Condition.visible).click();

    }
}
