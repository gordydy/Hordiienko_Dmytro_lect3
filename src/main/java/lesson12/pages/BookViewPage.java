package lesson12.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookViewPage {
    private WebElement addToCartButton = $("div.product-sidebar__ordering button.ui-btn-primary.add-to-cart");
    private ElementsCollection bookFormat = $$(".format__text");
    private ElementsCollection bookPrice = $$(".ui-price-display.price.simple");

    public void checkFormat() {
        if (addToCartButton.getText().equals("Купити зараз")) {
            for (int i = 0; i < bookFormat.size(); i++) {
                String format = bookFormat.get(i).text();
                switch (format) {
                    case "Паперова":
                        String paperBookPrice = bookPrice.get(i).text();
                        System.out.println("Paper book price: " + paperBookPrice);
                        break;
                    case "Електронна":
                        bookFormat.get(i).shouldBe().click();
                        String eBookPrice = bookPrice.get(i).text();
                        System.out.println("E-book price: " + eBookPrice);
                        break;
                    default:
                        System.out.println("No any book formats");
                }
            }
        } else {
            System.out.println("Book is out of stock");
        }
    }
}
