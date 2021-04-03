package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.OtcSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OtcSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void otcSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/otc/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/OtcSymbolsResponse.json")));

        final List<ExchangeSymbol> result = cloudClient.executeRequest(new OtcSymbolsRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final ExchangeSymbol exchangeSymbol = result.get(0);
        assertThat(exchangeSymbol.getSymbol()).isEqualTo("AAAG");
        assertThat(exchangeSymbol.getExchange()).isEqualTo("OTC");
        assertThat(exchangeSymbol.getName()).isEqualTo("AAA Century Group USA Inc.");
        assertThat(exchangeSymbol.getDate()).isEqualTo(LocalDate.of(2019, 5, 30));
        assertThat(exchangeSymbol.getType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(exchangeSymbol.getIexId()).isEqualTo("IEX_4A534652444A2D52");
        assertThat(exchangeSymbol.getRegion()).isEqualTo("US");
        assertThat(exchangeSymbol.getCurrency()).isEqualTo("USD");
        assertThat(exchangeSymbol.getEnabled()).isTrue();
    }

}
