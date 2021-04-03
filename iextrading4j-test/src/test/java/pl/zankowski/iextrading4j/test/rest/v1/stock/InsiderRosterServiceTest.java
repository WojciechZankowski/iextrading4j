package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderRoster;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderRosterRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class InsiderRosterServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void insiderRosterServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/insider-roster")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/InsiderRosterResponse.json")));

        final List<InsiderRoster> result = cloudClient.executeRequest(new InsiderRosterRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final InsiderRoster insiderRoster = result.get(0);
        assertThat(insiderRoster.getReportDate()).isEqualTo(1546387200000L);
        assertThat(insiderRoster.getPosition()).isEqualTo(BigDecimal.valueOf(12345));
        assertThat(insiderRoster.getEntityName()).isEqualTo("Random insider");
    }

}
