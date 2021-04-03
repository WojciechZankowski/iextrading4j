package pl.zankowski.iextrading4j.test.rest.v1.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.HistoricalCurrencyRate;
import pl.zankowski.iextrading4j.client.rest.request.forex.HistoricalRatesRequestBuilder;
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

public class HistoricalCurrencyRatesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void historicalCurrencyRateServiceTest() {
        stubFor(get(urlEqualTo(extendedPath("/fx/historical?symbols=EURUSD&on=2019-10-06")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/forex/HistoricalCurrencyRatesResponse.json")));

        final List<List<HistoricalCurrencyRate>> result = cloudClient.executeRequest(new HistoricalRatesRequestBuilder()
                .withSymbol("EURUSD")
                .withOn(LocalDate.of(2019, 10, 6))
                .build());

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).hasSize(1);

        final HistoricalCurrencyRate currencyRate = result.get(0).get(0);
        assertThat(currencyRate.getSymbol()).isEqualTo("EURUSD");
        assertThat(currencyRate.getRate()).isEqualTo(BigDecimal.valueOf(1.09834));
        assertThat(currencyRate.getTimestamp()).isEqualTo(1570406389000L);
        assertThat(currencyRate.getDate()).isEqualTo(LocalDate.of(2019, 10, 6));
    }
}
