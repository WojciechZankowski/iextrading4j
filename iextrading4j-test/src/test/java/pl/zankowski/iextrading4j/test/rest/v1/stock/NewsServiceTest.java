package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.News;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.NewsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class NewsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void newsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/news/last/10")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/NewsResponse.json")));

        final List<News> result = cloudClient.executeRequest(new NewsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final News news = result.get(0);
        assertThat(news.getDatetime()).isEqualTo(1545215400000L);
        assertThat(news.getHeadline()).isEqualTo("Voice Search Technology Creates A New Paradigm For Marketers");
        assertThat(news.getSource()).isEqualTo("Benzinga");
        assertThat(news.getUrl()).isEqualTo("https://cloud.iexapis.com/stable/news/article/8348646549980454");
        assertThat(news.getSummary()).isEqualTo("<p>Voice search is likely to grow by leap and bounds, with technological advancements leading to better adoption and fueling the growth cycle, according to Lindsay Boyajian, <a href=\"http://loupventures.com/how-the-future-of-voice-search-affects-marketers-today/\">a guest contributor at Loup Ventu...");
        assertThat(news.getRelated()).isEqualTo("AAPL,AMZN,GOOG,GOOGL,MSFT");
        assertThat(news.getImage()).isEqualTo("https://cloud.iexapis.com/stable/news/image/7594023985414148");
        assertThat(news.getLang()).isEqualTo("en");
        assertThat(news.getHasPaywall()).isTrue();
    }

}
