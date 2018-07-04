package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class EffectiveSpreadServiceTest extends BaseRestServiceTest {

    @Test
    public void effectiveSpreadServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/effective-spread"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/EffectiveSpreadResponse.json")));

        final List<EffectiveSpread> effectiveSpreadList = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("aapl")
                .build());

        final EffectiveSpread effectiveSpread = effectiveSpreadList.get(0);
        assertThat(effectiveSpread.getVolume()).isEqualTo(BigDecimal.valueOf(12678354));
        assertThat(effectiveSpread.getVenue()).isEqualTo("XBOS");
        assertThat(effectiveSpread.getVenueName()).isEqualTo("NASDAQ BX");
        assertThat(effectiveSpread.getEffectiveSpread()).isEqualTo(BigDecimal.valueOf(0.015299340000000002));
        assertThat(effectiveSpread.getEffectiveQuoted()).isEqualTo(BigDecimal.valueOf(0.9280835));
        assertThat(effectiveSpread.getPriceImprovement()).isEqualTo(BigDecimal.valueOf(0.0009107087));
    }

}
