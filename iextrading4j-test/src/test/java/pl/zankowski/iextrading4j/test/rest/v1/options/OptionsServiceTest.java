package pl.zankowski.iextrading4j.test.rest.v1.options;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.options.Option;
import pl.zankowski.iextrading4j.client.rest.request.options.OptionSide;
import pl.zankowski.iextrading4j.client.rest.request.options.OptionsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class OptionsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void symbolOptionsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/options")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/options/SymbolOptionsResponse.json")));

        final List<String> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).containsExactlyInAnyOrder("206586", "205048", "202133", "206054", "206882", "207862",
                "206203", "202857", "209239");
    }

    @Test
    void optionsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/options/201906/put")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/options/OptionsResponse.json")));

        final List<Option> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .withExpirationDate("201906")
                .withSide(OptionSide.PUT)
                .build());

        assertThat(result).hasSize(1);

        final Option option = result.get(0);
        assertThat(option.getSymbol()).isEqualTo("AAPL");
        assertThat(option.getId()).isEqualTo("0600180A92120LP2A520P");
        assertThat(option.getExpirationDate()).isEqualTo("20190705");
        assertThat(option.getContractSize()).isEqualTo(BigDecimal.valueOf(105));
        assertThat(option.getStrikePrice()).isEqualTo(BigDecimal.valueOf(216));
        assertThat(option.getClosingPrice()).isEqualTo(BigDecimal.valueOf(12.59));
        assertThat(option.getSide()).isEqualTo("put");
        assertThat(option.getType()).isEqualTo("equity");
        assertThat(option.getVolume()).isEqualTo(BigDecimal.ZERO);
        assertThat(option.getOpenInterest()).isEqualTo(BigDecimal.ZERO);
        assertThat(option.getBid()).isEqualTo(BigDecimal.valueOf(13.02));
        assertThat(option.getAsk()).isEqualTo(BigDecimal.valueOf(16.92));
        assertThat(option.getLastUpdated()).isEqualTo(LocalDate.of(2019, 7, 11));
    }

}
