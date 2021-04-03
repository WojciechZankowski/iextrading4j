package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.FundOwnership;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FundOwnershipRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FundOwnershipServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void fundOwnershipServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/fund-ownership")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/FundOwnershipResponse.json")));

        final List<FundOwnership> result = cloudClient.executeRequest(new FundOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final FundOwnership fundOwnership = result.get(0);
        assertThat(fundOwnership.getAdjHolding()).isEqualTo(BigDecimal.valueOf(150));
        assertThat(fundOwnership.getAdjMv()).isEqualTo(BigDecimal.valueOf(87));
        assertThat(fundOwnership.getEntityProperName()).isEqualTo("Random Corporation");
        assertThat(fundOwnership.getReportDate()).isEqualTo(1490918400000L);
        assertThat(fundOwnership.getReportedHolding()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(fundOwnership.getReportedMv()).isEqualTo(BigDecimal.valueOf(100));
    }

}
