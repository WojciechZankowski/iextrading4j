package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ThresholdSecuritiesRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class ThresholdSecuritiesServiceTest extends BaseRestServiceTest {

    @Test
    public void thresholdSecuritiesServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/threshold-securities/"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ThresholdSecuritiesResponse.json")));

        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(thresholdSecuritiesList).hasSize(1);

        final ThresholdSecurities thresholdSecurities = thresholdSecuritiesList.get(0);
        assertThat(thresholdSecurities.getTradeDate()).isEqualTo(LocalDate.of(2017, 10, 13));
        assertThat(thresholdSecurities.getSymbolInINETSymbology()).isEqualTo("ZIEXT");
        assertThat(thresholdSecurities.getSymbolInCQSSymbology()).isEqualTo("ZIEXT");
        assertThat(thresholdSecurities.getSymbolInCMSSymbology()).isEqualTo("ZIEXT");
        assertThat(thresholdSecurities.getCusip()).isEqualTo("0ZIEXT886");
        assertThat(thresholdSecurities.getSecurityName()).isEqualTo("ZIEXT Common Stock");
    }
}
