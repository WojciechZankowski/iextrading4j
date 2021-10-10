package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.MutualFundSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class MutualFundSymbolsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void mutualFundsSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/mutual-funds/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/MutualFundsSymbolsResponse.json")));

        final List<ExchangeSymbol> result = cloudClient.executeRequest(new MutualFundSymbolsRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final ExchangeSymbol exchangeSymbol = result.get(0);
        assertThat(exchangeSymbol.getSymbol()).isEqualTo("1SSEMYM1-MM");
        assertThat(exchangeSymbol.getExchange()).isEqualTo("MEX");
        assertThat(exchangeSymbol.getName()).isEqualTo("Moltifondo de Prevision 3 Banorte Generali Siefore SA de CV 1");
        assertThat(exchangeSymbol.getDate()).isEqualTo(LocalDate.of(2019, 5, 30));
        assertThat(exchangeSymbol.getType()).isEqualTo(SymbolType.OPEN_ENDED_FUND);
        assertThat(exchangeSymbol.getIexId()).isEqualTo("IEX_485A304E42592D52");
        assertThat(exchangeSymbol.getRegion()).isEqualTo("MX");
        assertThat(exchangeSymbol.getCurrency()).isEqualTo("MXN");
        assertThat(exchangeSymbol.getEnabled()).isTrue();
    }

}
