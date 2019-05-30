package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Ownership;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InstitutionalOwnershipRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class InstitutionalOwnershipServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void institutionalOwnershipServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/institutional-ownership")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/InstitutionalOwnershipResponse.json")));

        final List<Ownership> result = cloudClient.executeRequest(new InstitutionalOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final Ownership ownership = result.get(0);
        assertThat(ownership.getAdjHolding()).isEqualTo(BigDecimal.valueOf(10085320));
        assertThat(ownership.getAdjMv()).isEqualTo(BigDecimal.valueOf(59188155));
        assertThat(ownership.getEntityProperName()).isEqualTo("Random Corp.");
        assertThat(ownership.getReportDate()).isEqualTo(1548892800000L);
        assertThat(ownership.getReportedHolding()).isEqualTo(BigDecimal.valueOf(2085320));
    }

}
