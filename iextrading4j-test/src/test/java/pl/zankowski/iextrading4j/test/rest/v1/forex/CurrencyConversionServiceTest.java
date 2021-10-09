package pl.zankowski.iextrading4j.test.rest.v1.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyConversion;
import pl.zankowski.iextrading4j.client.rest.request.forex.CurrencyConversionRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyConversionServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void currencyConversionServiceTest() {
        stubFor(get(urlEqualTo(extendedPath("/fx/convert?symbols=USDGBP&amount=10")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/forex/CurrencyConversionResponse.json")));

        final List<CurrencyConversion> result = cloudClient.executeRequest(new CurrencyConversionRequestBuilder()
                .withSymbol("USDGBP")
                .withAmount(BigDecimal.TEN)
                .build());

        assertThat(result).hasSize(1);

        final CurrencyConversion currencyConversion = result.get(0);
        assertThat(currencyConversion.getSymbol()).isEqualTo("USDGBP");
        assertThat(currencyConversion.getRate()).isEqualTo(BigDecimal.valueOf(0.755));
        assertThat(currencyConversion.getTimestamp()).isEqualTo(1288282222000L);
        assertThat(currencyConversion.getAmount()).isEqualTo(BigDecimal.valueOf(56.113));
    }
}
