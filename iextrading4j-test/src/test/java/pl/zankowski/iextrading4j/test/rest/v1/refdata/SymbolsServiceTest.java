package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void symbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/SymbolsResponse.json")));

        final List<ExchangeSymbol> result = cloudClient.executeRequest(new SymbolsRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final ExchangeSymbol symbol = result.get(0);
        assertThat(symbol.getSymbol()).isEqualTo("A");
        assertThat(symbol.getExchange()).isEqualTo("NYS");
        assertThat(symbol.getName()).isEqualTo("Agilent Technologies Inc.");
        assertThat(symbol.getDate()).isEqualTo(LocalDate.of(2019, 5, 30));
        assertThat(symbol.getType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(symbol.getIexId()).isEqualTo("IEX_46574843354B2D52");
        assertThat(symbol.getRegion()).isEqualTo("US");
        assertThat(symbol.getCurrency()).isEqualTo("USD");
        assertThat(symbol.getEnabled()).isTrue();
    }

}
