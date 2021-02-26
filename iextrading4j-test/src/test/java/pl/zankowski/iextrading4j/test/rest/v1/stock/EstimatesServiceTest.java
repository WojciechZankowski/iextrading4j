package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Estimate;
import pl.zankowski.iextrading4j.api.stocks.v1.Estimates;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.EstimatesRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class EstimatesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void estimatesServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/estimates")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/EstimatesResponse.json")));

        final Estimates estimates = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(estimates.getSymbol()).isEqualTo("AAPL");
        assertThat(estimates.getEstimates()).hasSize(1);

        final Estimate result = estimates.getEstimates().get(0);
        assertThat(result.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(2.11));
        assertThat(result.getAnnounceTime()).isEqualTo("AMC");
        assertThat(result.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(37));
        assertThat(result.getReportDate()).isEqualTo(LocalDate.of(2019, 7, 22));
        assertThat(result.getFiscalPeriod()).isEqualTo("Q2 2019");
        assertThat(result.getFiscalEndDate()).isEqualTo(LocalDate.of(2019, 6, 30));
        assertThat(result.getCurrency()).isEqualTo("USD");
    }

}
