package lesson12;


import com.codeborne.selenide.WebDriverRunner;
import lesson12.config.Browser;
import lesson12.pages.BookViewPage;
import lesson12.pages.MainBookPage;
import lesson12.pages.SearchResultPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/*1. Відкрити https://www.yakaboo.ua/
2. Виконати пошук по назві книги
3. Відкрити сторінку книги
4. Перевірити чи є паперова книга в наявності, якщо ні, перевірити чи є електронна версія в наявності.
5. Якщо обидві книги відсутні - вивести меседж що книга не в наявності.
6. Якщо книга в наявності - вивести ціну паперової чи електронної версії*/
public class BookTest {
    public static final String BASE_URL = "https://www.yakaboo.ua/";
    public String bookName = "Русалка Карпатська (зелена обкладинка)";
    /*Як говорити з дитиною, щоб вона слухала, чула і розуміла - E-book
    Несезон - paper + e-book
    Русалка Карпатська (зелена обкладинка)  - out of stock*/
    String url;
    MainBookPage mainBookPage = new MainBookPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    BookViewPage bookViewPage = new BookViewPage();

    @BeforeTest
    public void setBrowser() {
        Browser.setBrowser();
    }

    @Test(priority = 1)
    public void searchBook() {
        open(BASE_URL);
        mainBookPage.searchBook(bookName);
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 2)
    public void openBookPage() {
        searchResultPage.assertBookIsFound(bookName);
        searchResultPage.openBook();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Test(priority = 3)
    public void checkExistFormat() {
        open(url);
        bookViewPage.checkFormat();
    }


}
