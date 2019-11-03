package pl.zankowski.iextrading4j.test.rest.v1.datapoint;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.datapoint.FieldMetadata;
import pl.zankowski.iextrading4j.api.datapoint.TimeSeriesMetadata;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.TimeSeriesRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TimeSeriesServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void timeSeriesServiceTest() {
        stubFor(get(urlEqualTo(path("/time-series")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/datapoints/TimeSeriesResponse.json")));

        final List<TimeSeriesMetadata> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .build());

        assertThat(result).hasSize(1);

        final TimeSeriesMetadata metadata = result.get(0);

        assertThat(metadata.getId()).isEqualTo("PREMIUM_WALLSTREETHORIZON_OPTION_EXPIRATION_DATE");
        assertThat(metadata.getDescription()).isEqualTo("Company Events (Option Expiration Date)");
        assertThat(metadata.getSchema().getType()).isEqualTo("object");
        assertThat(metadata.getSchema().getProperties()).contains(entry("eventId", new FieldMetadata("string")));
        assertThat(metadata.getSchema().getRequired()).isEmpty();
        assertThat(metadata.getSchema().isAdditionalProperties()).isTrue();
        assertThat(metadata.getWeightKey()).isEqualTo("PREMIUM_WALLSTREETHORIZON_OPTION_EXPIRATION_DATE");
        assertThat(metadata.getWeight()).isEqualTo(BigDecimal.valueOf(1125000L));
        assertThat(metadata.getCreated()).isEqualTo(LocalDateTime.of(2019, 10, 14, 18, 4, 16));
        assertThat(metadata.getLastUpdated()).isEqualTo(LocalDateTime.of(2019, 10, 14, 18, 4, 16));
    }

    @Test
    public void keyTimeSeriesServiceTest() {
        stubFor(get(urlEqualTo(path("/time-series/REPORTED_FINANCIALS/AAPL/10-Q")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/datapoints/KeyTimeSeriesResponse.json")));

        final List<Map<String, String>> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withSubKey("10-Q")
                .build());

        assertThat(result).hasSize(1);

        final Map<String, String> values = result.get(0);
        assertThat(values).hasSize(3);

        assertThat(values.get("AccountsPayableCurrent")).isEqualTo("31339898657");
        assertThat(values.get("formFiscalYear")).isEqualTo("2090");
        assertThat(values.get("version")).isEqualTo("ausa-gp");
    }

}
