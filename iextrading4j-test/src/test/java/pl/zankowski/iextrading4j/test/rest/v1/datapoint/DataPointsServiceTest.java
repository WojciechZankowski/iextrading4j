package pl.zankowski.iextrading4j.test.rest.v1.datapoint;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.DataPointsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class DataPointsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void dataPointsServiceTest() {
        stubFor(get(urlEqualTo(path("/data-points/AAPL")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/datapoints/DataPointsResponse.json")));

        final List<DataPoint> result = cloudClient.executeRequest(new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(2);

        final DataPoint firstPoint = result.get(0);
        assertThat(firstPoint.getKey()).isEqualTo("QUOTE-LATESTPRICE");
        assertThat(firstPoint.getWeight()).isEqualTo(BigDecimal.ONE);
        assertThat(firstPoint.getDescription()).isEqualTo("Quote: latestPrice");
        assertThat(firstPoint.getLastUpdated()).isEqualTo(OffsetDateTime.of(2019, 4, 15, 13, 56, 39, 0, ZoneOffset.ofHours(0)));

        final DataPoint secondPoint = result.get(1);
        assertThat(secondPoint.getKey()).isEqualTo("LATEST-FINANCIAL-REPORT-DATE");
        assertThat(secondPoint.getWeight()).isEqualTo(BigDecimal.ZERO);
        assertThat(secondPoint.getDescription()).isEqualTo("Latest financials report date available");
        assertThat(secondPoint.getLastUpdated()).isEqualTo(OffsetDateTime.of(2019, 4, 15, 8, 8, 10, 0, ZoneOffset.ofHours(0)));
    }

    @Test
    void keyDataPointServiceTest() {
        stubFor(get(urlEqualTo(path("/data-points/AAPL/QUOTE-CLOSE")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/datapoints/KeyDataPointResponse.json")));

        final String result = cloudClient.executeRequest(new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .withKey("QUOTE-CLOSE")
                .build());

        assertThat(result).isEqualTo("180.82");
    }

}
