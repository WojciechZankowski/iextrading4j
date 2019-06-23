package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.iextrading4j.api.refdata.v1.UsExchange;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsExchangeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class UsExchangesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void usExchangesServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/market/us/exchanges")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/UsExchangesResponse.json")));

        final List<UsExchange> result = cloudClient.executeRequest(new UsExchangeRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final UsExchange exchange = result.get(0);
        assertThat(exchange.getMic()).isEqualTo("ARCX");
        assertThat(exchange.getName()).isEqualTo("NYSE Arca");
        assertThat(exchange.getLongName()).isEqualTo("NYSE ARCA");
        assertThat(exchange.getTapeId()).isEqualTo("P");
        assertThat(exchange.getOatsId()).isEqualTo("XP");
        assertThat(exchange.getRefId()).isEqualTo("IEXG");
        assertThat(exchange.getType()).isEqualTo("equities");
    }

}
