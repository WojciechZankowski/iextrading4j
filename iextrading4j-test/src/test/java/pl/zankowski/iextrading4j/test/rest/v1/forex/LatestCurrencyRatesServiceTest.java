package pl.zankowski.iextrading4j.test.rest.v1.forex;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.rest.request.forex.LatestCurrencyRatesRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class LatestCurrencyRatesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void latestCurrencyRateServiceTest() {
        stubFor(get(urlEqualTo(extendedPath("/fx/latest?symbols=USDGBP")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/forex/LatestCurrencyRatesResponse.json")));

        final List<CurrencyRate> result = cloudClient.executeRequest(new LatestCurrencyRatesRequestBuilder()
                .withSymbol("USDGBP")
                .build());

        assertThat(result).hasSize(1);

        final CurrencyRate currencyRate = result.get(0);
        assertThat(currencyRate.getSymbol()).isEqualTo("USDGBP");
        assertThat(currencyRate.getRate()).isEqualTo(BigDecimal.valueOf(0.755));
        assertThat(currencyRate.getTimestamp()).isEqualTo(1288282222000L);
        assertThat(currencyRate.isDerived()).isTrue();
    }
}
