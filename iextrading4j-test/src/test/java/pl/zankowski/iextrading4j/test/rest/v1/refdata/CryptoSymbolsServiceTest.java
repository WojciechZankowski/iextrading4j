package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.CryptoSymbols;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.CryptoSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CryptoSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void cryptoSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/crypto/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/CryptoSymbolsResponse.json")));

        final List<CryptoSymbols> result = cloudClient.executeRequest(new CryptoSymbolsRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final CryptoSymbols symbol = result.get(0);
        assertThat(symbol.getSymbol()).isEqualTo("BTCUSD");
        assertThat(symbol.getName()).isEqualTo("Bitcoin to USD");
        assertThat(symbol.getExchange()).isNull();
        assertThat(symbol.getDate()).isEqualTo(LocalDate.of(2021, 12, 28));
        assertThat(symbol.getType()).isEqualTo("crypto");
        assertThat(symbol.getRegion()).isEqualTo("US");
        assertThat(symbol.getCurrency()).isEqualTo("USD");
        assertThat(symbol.getEnabled()).isTrue();
    }

}
