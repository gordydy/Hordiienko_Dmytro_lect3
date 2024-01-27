package lesson10.apiImdb;

import java.io.IOException;

import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ImdbApi {

    public final ImdbRestClient client = new ImdbRestClient();

    public ResponseBody getTopChartResponse() throws IOException {
        return client.films.getTopChart().execute().body();
    }

    public LinkedHashMap<String, List<Object>> getTopChart() throws IOException {
        String htmlString = getTopChartResponse().string();
        Element document = Jsoup.parse(htmlString);
        Elements summaryTag = document.select("li");
        LinkedHashMap<String, List<Object>> allFilms = new LinkedHashMap<>();

        for (Element el : summaryTag) {
            Element summaryClass = el.select(".ipc-metadata-list-summary-item__c").first();
            if (summaryClass != null) {
                String href = summaryClass.select("a").attr("href");
                String h3Text = summaryClass.select("h3").text();
                String yearElement = summaryClass.select(".sc-1e00898e-8.hsHAHC.cli-title-metadata-item").first().text();
                String ratingElement = summaryClass.select(".ipc-rating-star.ipc-rating-star--base.ipc-rating-star--imdb.ratingGroup--imdb-rating").attr("aria-label");
                int dotIndex = h3Text.indexOf('.');
                if (dotIndex != -1) {
                    String titleWithoutNumber = h3Text.substring(dotIndex + 1).trim();
                    int twoDotsIndex = ratingElement.indexOf(':');
                    if (twoDotsIndex != -1) {
                        String ratingWithoutText = ratingElement.substring(twoDotsIndex + 1).trim();
                        System.out.println(ratingElement);
                        String link = ImdbRestClient.BASE_URL + href;
                        List<Object> filmInfo = new ArrayList<>();
                        filmInfo.add(titleWithoutNumber);
                        filmInfo.add(yearElement);
                        filmInfo.add(ratingWithoutText);
                        allFilms.put(link, filmInfo);
                    }
                }
            }
        }
        return allFilms;
    }

    @DataProvider(name = "filmData")
    public Iterator<Object[]> getTop100FilmData() throws IOException {
        Map<String, List<Object>> topChart = getTopChart();

        Iterator<Object[]> filmDataIterator = topChart.entrySet().stream()
                .limit(100)
                .map(entry -> {
                    String filmLink = entry.getKey();
                    List<Object> filmInfo = entry.getValue();
                    String title = String.valueOf(filmInfo.get(0));
                    String year = String.valueOf(filmInfo.get(1));
                    String rating = String.valueOf(filmInfo.get(2));
                    return new Object[]{filmLink, title, year, rating};
                })
                .iterator();

        return filmDataIterator;
    }

}

