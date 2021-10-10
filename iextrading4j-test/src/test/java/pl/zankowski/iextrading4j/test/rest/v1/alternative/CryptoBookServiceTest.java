package pl.zankowski.iextrading4j.test.rest.v1.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoBookRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class CryptoBookServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void cryptoServiceTest() {
        stubFor(get(urlEqualTo(path("/crypto/BTCUSD/book")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/CryptoBookResponse.json")));

        final Book book = cloudClient.executeRequest(new CryptoBookRequestBuilder()
                .withSymbol("BTCUSD")
                .build());

        assertThat(book.getSymbol()).isEqualTo("BTCUSD");
        assertThat(book.getAsks()).hasSize(1);

        final BookEntry ask = book.getAsks().get(0);
        assertThat(ask.getPrice()).isEqualTo(BigDecimal.valueOf(10421));
        assertThat(ask.getSize()).isEqualTo(BigDecimal.valueOf(0.76747926));
        assertThat(ask.getTimestamp()).isEqualTo(1572620748579L);

        assertThat(book.getBids()).hasSize(1);

        final BookEntry bid = book.getBids().get(0);
        assertThat(bid.getPrice()).isEqualTo(BigDecimal.valueOf(1000));
        assertThat(bid.getSize()).isEqualTo(BigDecimal.valueOf(0.5));
        assertThat(bid.getTimestamp()).isEqualTo(1574688905930L);
    }

}
