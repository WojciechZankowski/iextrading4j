package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.News;
import pl.zankowski.iextrading4j.client.rest.request.stocks.NewsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class NewsServiceTest extends BaseRestServiceTest {

    @Test
    public void newsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/news/last/10"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/NewsResponse.json")));

        final List<News> newsList = iexTradingClient.executeRequest(new NewsRequestBuilder()
                .withSymbol("aapl")
                .build());

        final News firstNews = newsList.get(0);
        assertThat(firstNews.getDatetime()).isEqualTo(OffsetDateTime.of(
                LocalDateTime.of(2017,11,10,21,6, 0),
                ZoneOffset.of("Z")));
        assertThat(firstNews.getHeadline()).isEqualTo("Netflix dropped 5 percent this week, after rallying all year");
        assertThat(firstNews.getSource()).isEqualTo("CNBC");
        assertThat(firstNews.getUrl()).isEqualTo("https://api.iextrading.com/1.0/stock/aapl/article/8464142968106298");
        assertThat(firstNews.getSummary()).isEqualTo("No summary available.");
        assertThat(firstNews.getRelated()).isEqualTo("AAPL,AMZN,FB,GOOGL,NFLX");
        assertThat(firstNews.getImage()).isEqualTo("https://api.iextrading.com/1.0/stock/aapl/news-image/8505362764378508");

        final News secondNews = newsList.get(1);
        assertThat(secondNews.getDatetime()).isEqualTo(OffsetDateTime.of(
                LocalDateTime.of(2017,11,10,19,16, 0),
                ZoneOffset.of("Z")));
        assertThat(secondNews.getHeadline()).isEqualTo("Apple will issue a fix for iPhone X devices that seize up in the cold");
        assertThat(secondNews.getSource()).isEqualTo("CNBC");
        assertThat(secondNews.getUrl()).isEqualTo("https://api.iextrading.com/1.0/stock/aapl/article/5121696418454999");
        assertThat(secondNews.getSummary()).isEqualTo("No summary available.");
        assertThat(secondNews.getRelated()).isEqualTo("AAPL");
        assertThat(secondNews.getImage()).isEqualTo("https://api.iextrading.com/1.0/stock/market/news-image/6570157284679204");
    }

}
