package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolDescription;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SearchSymbolRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class SearchSymbolServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void searchSymbolsServiceTest() {
        stubFor(get(urlEqualTo(path("/search/apple")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/SearchSymbolResponse.json")));

        final List<SymbolDescription> result = cloudClient.executeRequest(new SearchSymbolRequestBuilder()
                .withFragment("apple")
                .build());

        assertThat(result).hasSize(2);

        final SymbolDescription appleSymbol = result.get(0);
        assertThat(appleSymbol.getSymbol()).isEqualTo("AAPL");
        assertThat(appleSymbol.getSecurityName()).isEqualTo("Apple Inc.");
        assertThat(appleSymbol.getSecurityType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(appleSymbol.getRegion()).isEqualTo("US");
        assertThat(appleSymbol.getExchange()).isEqualTo("NAS");
        assertThat(appleSymbol.getSector()).isEqualTo("fitugMurnaacn");
        assertThat(appleSymbol.getCurrency()).isEqualTo("USD");

        final SymbolDescription appleHospitalitySymbol = result.get(1);
        assertThat(appleHospitalitySymbol.getSymbol()).isEqualTo("APLE");
        assertThat(appleHospitalitySymbol.getSecurityName()).isEqualTo("Apple Hospitality REIT Inc.");
        assertThat(appleHospitalitySymbol.getSecurityType()).isEqualTo(SymbolType.COMMON_STOCK);
        assertThat(appleHospitalitySymbol.getRegion()).isEqualTo("US");
        assertThat(appleHospitalitySymbol.getExchange()).isEqualTo("NYS");
        assertThat(appleHospitalitySymbol.getSector()).isEqualTo("fitugMurnaacn");
        assertThat(appleHospitalitySymbol.getCurrency()).isEqualTo("USD");

    }

}
