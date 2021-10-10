package pl.zankowski.iextrading4j.test.rest.v1.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void exchangeRateServiceTest() {
        stubFor(get(urlEqualTo(path("/fx/rate/EUR/USD")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/forex/ExchangeRatesResponse.json")));

        final ExchangeRate result = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "USD"))
                .build());

        assertThat(result.getDate()).isEqualTo(LocalDate.of(2019, 3, 5));
        assertThat(result.getFromCurrency()).isEqualTo("EUR");
        assertThat(result.getToCurrency()).isEqualTo("USD");
        assertThat(result.getRate()).isEqualTo(BigDecimal.valueOf(1.13));
    }

}
