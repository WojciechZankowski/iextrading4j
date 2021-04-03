package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderSummary;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderSummaryRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class InsiderSummaryServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void insiderSummaryServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/insider-summary")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/InsiderSummaryResponse.json")));

        final List<InsiderSummary> result = cloudClient.executeRequest(new InsiderSummaryRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final InsiderSummary insiderSummary = result.get(0);
        assertThat(insiderSummary.getFullName()).isEqualTo("John Appleseed");
        assertThat(insiderSummary.getNetTransacted()).isEqualTo(BigDecimal.valueOf(-15));
        assertThat(insiderSummary.getReportedTitle()).isEqualTo("General Counsel");
        assertThat(insiderSummary.getTotalBought()).isEqualTo(BigDecimal.ZERO);
        assertThat(insiderSummary.getTotalSold()).isEqualTo(BigDecimal.valueOf(-15));
    }

}
