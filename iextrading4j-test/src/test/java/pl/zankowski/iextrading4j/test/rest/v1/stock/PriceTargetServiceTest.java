package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.PriceTarget;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.PriceTargetRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceTargetServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void priceTargetServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/price-target")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/PriceTargetResponse.json")));

        final PriceTarget result = cloudClient.executeRequest(new PriceTargetRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result.getSymbol()).isEqualTo("AAPL");
        assertThat(result.getUpdatedDate()).isEqualTo(LocalDate.of(2019, 5, 24));
        assertThat(result.getPriceTargetAverage()).isEqualTo(BigDecimal.valueOf(212.77));
        assertThat(result.getPriceTargetHigh()).isEqualTo(BigDecimal.valueOf(245));
        assertThat(result.getPriceTargetLow()).isEqualTo(BigDecimal.valueOf(150));
        assertThat(result.getNumberOfAnalysts()).isEqualTo(BigDecimal.valueOf(34));
    }

}
