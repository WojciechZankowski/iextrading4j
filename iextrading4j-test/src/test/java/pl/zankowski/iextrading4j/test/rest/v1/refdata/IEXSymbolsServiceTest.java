package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Symbol;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IEXSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IEXSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void iexSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/iex/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/IEXSymbolsResponse.json")));

        final List<Symbol> result = cloudClient.executeRequest(new IEXSymbolsRequestBuilder().build());

        assertThat(result).hasSize(1);

        final Symbol symbol = result.get(0);
        assertThat(symbol.getSymbol()).isEqualTo("A");
        assertThat(symbol.getDate()).isEqualTo(LocalDate.of(2019, 5, 30));
        assertThat(symbol.getEnabled()).isTrue();
    }

}
