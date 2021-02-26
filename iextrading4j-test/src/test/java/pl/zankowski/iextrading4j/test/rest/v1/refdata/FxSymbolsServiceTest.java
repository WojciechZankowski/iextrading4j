package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Currency;
import pl.zankowski.iextrading4j.api.refdata.v1.FxSymbol;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.FxSymbolRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FxSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void fxSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/fx/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/FxSymbolsResponse.json")));

        final FxSymbol result = cloudClient.executeRequest(new FxSymbolRequestBuilder().build());

        assertThat(result.getCurrencies()).hasSize(1);

        final Currency currency = result.getCurrencies().get(0);
        assertThat(currency.getCode()).isEqualTo("USD");
        assertThat(currency.getName()).isEqualTo("U.S. Dollar");

        assertThat(result.getPairs()).hasSize(1);

        final Pair pair = result.getPairs().get(0);
        assertThat(pair.getFrom()).isEqualTo("EUR");
        assertThat(pair.getTo()).isEqualTo("USD");
    }

}
