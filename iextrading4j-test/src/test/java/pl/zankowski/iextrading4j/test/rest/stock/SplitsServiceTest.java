package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SplitsServiceTest extends BaseRestServiceTest {

    @Test
    public void splitsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/splits/5y"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/FiveYearsSplitsResponse.json")));


        final List<Split> splitList = iexTradingClient.executeRequest(new SplitsRequestBuilder()
                .withSplitsRange(SplitsRange.FIVE_YEARS)
                .withSymbol("aapl")
                .build());

        final Split split = splitList.get(0);
        assertThat(split.getExDate()).isEqualTo(LocalDate.of(2014, 6, 9));
        assertThat(split.getDeclaredDate()).isEqualTo(LocalDate.of(2014, 4, 23));
        assertThat(split.getRecordDate()).isEqualTo(LocalDate.of(2014, 6, 2));
        assertThat(split.getPaymentDate()).isEqualTo(LocalDate.of(2014, 6, 6));
        assertThat(split.getRatio()).isEqualTo(BigDecimal.valueOf(0.142857));
        assertThat(split.getToFactor()).isEqualTo(BigDecimal.valueOf(7));
        assertThat(split.getForFactor()).isEqualTo(BigDecimal.valueOf(1));
    }

}
