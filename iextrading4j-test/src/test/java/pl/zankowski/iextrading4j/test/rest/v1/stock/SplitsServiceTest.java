package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Split;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.SplitsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SplitsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void splitsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/splits/5y")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/SplitsResponse.json")));


        final List<Split> splitList = cloudClient.executeRequest(new SplitsRequestBuilder()
                .withSplitsRange(SplitsRange.FIVE_YEARS)
                .withSymbol("AAPL")
                .build());

        final Split split = splitList.get(0);
        assertThat(split.getExDate()).isEqualTo(LocalDate.of(2017, 8, 10));
        assertThat(split.getDeclaredDate()).isEqualTo(LocalDate.of(2017, 8, 1));
        assertThat(split.getRatio()).isEqualTo(BigDecimal.valueOf(0.142857));
        assertThat(split.getToFactor()).isEqualTo(BigDecimal.valueOf(7));
        assertThat(split.getFromFactor()).isEqualTo(BigDecimal.valueOf(1));
        assertThat(split.getDescription()).isEqualTo("7-for-1 split");
        assertThat(split.getDate()).isEqualTo(LocalDate.of(2019, 8, 10));
    }

}
