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

class SplitsServiceTest extends BaseIEXCloudV1ServiceTest {

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
        assertThat(split.getExDate()).isEqualTo(LocalDate.of(2020, 8, 28));
        assertThat(split.getDeclaredDate()).isEqualTo(LocalDate.of(2017, 8, 1));
        assertThat(split.getRatio()).isEqualTo(BigDecimal.valueOf(0.26));
        assertThat(split.getToFactor()).isEqualTo(BigDecimal.valueOf(4));
        assertThat(split.getFromFactor()).isEqualTo(BigDecimal.valueOf(1));
        assertThat(split.getDescription()).isEqualTo("4-for-1 split");
        assertThat(split.getRefid()).isEqualTo("6928141");
        assertThat(split.getSymbol()).isEqualTo("AAPL");
    }

}
