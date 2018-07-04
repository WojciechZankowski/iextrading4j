package pl.zankowski.iextrading4j.test.rest.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SymbolsServiceTest extends BaseRestServiceTest {

    @Test
    public void symbolsServiceTest() {
        stubFor(get(urlEqualTo("/ref-data/symbols"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/refdata/SymbolsResponse.json")));

        final List<ExchangeSymbol> exchangeSymbols = iexTradingClient.executeRequest(
                new SymbolsRequestBuilder().build());

        final ExchangeSymbol aSymbol = exchangeSymbols.get(0);
        assertThat(aSymbol.getSymbol()).isEqualTo("A");
        assertThat(aSymbol.getName()).isEqualTo("Agilent Technologies Inc.");
        assertThat(aSymbol.getDate()).isEqualTo(LocalDate.of(2017, 11, 10));
        assertThat(aSymbol.getEnabled()).isTrue();
        assertThat(aSymbol.getType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(aSymbol.getIexId()).isEqualTo(12042);

        final ExchangeSymbol aaSymbol = exchangeSymbols.get(1);
        assertThat(aaSymbol.getSymbol()).isEqualTo("AA");
        assertThat(aaSymbol.getName()).isEqualTo("Alcoa Corporation");
        assertThat(aaSymbol.getDate()).isEqualTo(LocalDate.of(2017, 11, 10));
        assertThat(aaSymbol.getEnabled()).isTrue();
        assertThat(aaSymbol.getType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(aaSymbol.getIexId()).isEqualTo(6667);
    }

}
