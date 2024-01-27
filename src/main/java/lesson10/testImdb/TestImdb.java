package lesson10.testImdb;


import com.codeborne.selenide.Selenide;
import lesson10.apiImdb.ImdbApi;
import lesson10.config.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/*Tecт має брати перші 100 фільмів з https://www.imdb.com/chart/top/
Робити з них DataProvider
Заходити на кожен з 100 фильмів та перевіряти що Назва фільму, рік випуску, та рейтинг (оцінка) співпадають між собою на https://www.imdb.com/chart/top/ та на сторінці фільму.*/
public class TestImdb extends ImdbApi {

    @BeforeMethod
    public void beforeMethod() {
        Browser.setBrowser();
    }

    @Test(dataProvider = "filmData")
    public void imdbTop100ChartTest(String filmLink, String title, String year, String rating) throws IOException {
        Selenide.open(filmLink);

        Assert.assertEquals(title, $("[data-testid='hero__primary-text']").getText(), "Title isn't equal");
        Assert.assertEquals(year, $$(".ipc-link.ipc-link--baseAlt.ipc-link--inherit-color").get(5).getText(), "Year isn't equal");
        Assert.assertEquals(rating, $(".sc-bde20123-1.cMEQkK").getText(), "Rating isn't equal");
    }
}










