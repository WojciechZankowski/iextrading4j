package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.DataPointsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.TimeSeriesRequestBuilder;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DataPointsAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    void dataPointsTest() {
        final RestRequest<List<DataPoint>> request = new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .build();

        final List<DataPoint> dataPoints = cloudClient.executeRequest(request);
        System.out.println(dataPoints);
        assertThat(dataPoints).isNotNull();
    }

    @Test
    void keyDataPointTest() {
        final RestRequest<String> request = new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .withKey("ACCOUNTSPAYABLE")
                .build();

        final String response = cloudClient.executeRequest(request);

        assertThat(response).isNotNull();
    }

    @Test
    void timeSeriesTest() {
        final List<Map<String, String>> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .withId("advanced_splits")
                .withKey("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void keyTimeSeriesTest() {
        final List<Map<String, String>> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withSubKey("10-Q")
                .build());
        assertThat(result).isNotNull();
    }

}
