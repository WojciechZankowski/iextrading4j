package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void exchangesServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/exchanges")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/ExchangesResponse.json")));

        final List<Exchange> result = cloudClient.executeRequest(new ExchangeRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final Exchange exchange = result.get(0);
        assertThat(exchange.getExchange()).isEqualTo("LON");
        assertThat(exchange.getRegion()).isEqualTo("GB");
        assertThat(exchange.getDescription()).isEqualTo("London Stock Exchange");
        assertThat(exchange.getMic()).isEqualTo("XLON");
        assertThat(exchange.getExchangeSuffix()).isEqualTo("-LN");
    }

}
