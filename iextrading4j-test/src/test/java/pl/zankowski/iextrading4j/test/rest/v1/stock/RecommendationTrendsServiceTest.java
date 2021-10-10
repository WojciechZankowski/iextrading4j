package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.RecommendationTrends;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.RecommendationTrendsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class RecommendationTrendsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void recommendationTrendsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/recommendation-trends")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/RecommendationTrendsResponse.json")));

        final List<RecommendationTrends> result = cloudClient.executeRequest(new RecommendationTrendsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final RecommendationTrends trends = result.get(0);
        assertThat(trends.getConsensusEndDate()).isEqualTo(1542240000000L);
        assertThat(trends.getConsensusStartDate()).isEqualTo(1541462400000L);
        assertThat(trends.getCorporateActionsAppliedDate()).isEqualTo(1055721600000L);
        assertThat(trends.getRatingBuy()).isEqualTo(BigDecimal.valueOf(8));
        assertThat(trends.getRatingHold()).isEqualTo(BigDecimal.ONE);
        assertThat(trends.getRatingNone()).isEqualTo(BigDecimal.valueOf(2));
        assertThat(trends.getRatingOverweight()).isEqualTo(BigDecimal.valueOf(2));
        assertThat(trends.getRatingScaleMark()).isEqualTo(BigDecimal.valueOf(1.042857));
        assertThat(trends.getRatingSell()).isEqualTo(BigDecimal.ONE);
        assertThat(trends.getRatingUnderweight()).isEqualTo(BigDecimal.ONE);
    }

}
