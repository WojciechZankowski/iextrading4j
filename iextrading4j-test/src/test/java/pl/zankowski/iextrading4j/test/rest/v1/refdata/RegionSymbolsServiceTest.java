package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.RegionSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class RegionSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void regionSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/region/GB/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/RegionSymbolsResponse.json")));

        final List<ExchangeSymbol> result = cloudClient.executeRequest(new RegionSymbolsRequestBuilder()
                .withRegion("GB")
                .build());

        assertThat(result).hasSize(1);

        final ExchangeSymbol symbol = result.get(0);
        assertThat(symbol.getSymbol()).isEqualTo("TDE-LN");
        assertThat(symbol.getExchange()).isEqualTo("LON");
        assertThat(symbol.getName()).isEqualTo("Telefonica SA");
        assertThat(symbol.getDate()).isEqualTo(LocalDate.of(2019, 5, 30));
        assertThat(symbol.getType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(symbol.getIexId()).isEqualTo("IEX_4A435150514C2D52");
        assertThat(symbol.getRegion()).isEqualTo("GB");
        assertThat(symbol.getCurrency()).isEqualTo("EUR");
        assertThat(symbol.getEnabled()).isTrue();
    }

}
