package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.BookRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class BookServiceTest extends BaseRestServiceTest {

    @Test
    public void bookServiceTest() {
        stubFor(get(urlEqualTo("/deep/book?symbols=YELP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/BookResponse.json")));

        final Map<String, Book> bookMap = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("YELP")
                .build());

        final Book yelp = bookMap.get("YELP");

        final List<BookEntry> bidList = yelp.getBids();

        final BookEntry firstBid = bidList.get(0);
        assertThat(firstBid.getPrice()).isEqualTo(BigDecimal.valueOf(45.57));
        assertThat(firstBid.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(firstBid.getTimestamp()).isEqualTo(1510959828056L);

        final BookEntry secondBid = bidList.get(1);
        assertThat(secondBid.getPrice()).isEqualTo(BigDecimal.valueOf(44.62));
        assertThat(secondBid.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(secondBid.getTimestamp()).isEqualTo(1510952183046L);

        final List<BookEntry> askList = yelp.getAsks();

        final BookEntry firstAsk = askList.get(0);
        assertThat(firstAsk.getPrice()).isEqualTo(BigDecimal.valueOf(46.73));
        assertThat(firstAsk.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(firstAsk.getTimestamp()).isEqualTo(1510961490574L);

        final BookEntry secondAsk = askList.get(1);
        assertThat(secondAsk.getPrice()).isEqualTo(BigDecimal.valueOf(46.78));
        assertThat(secondAsk.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(secondAsk.getTimestamp()).isEqualTo(1510961453676L);
    }

}
