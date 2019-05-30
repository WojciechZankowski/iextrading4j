package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.DataPointsRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataPointsAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void dataPointsTest() {
        final RestRequest<List<DataPoint>> request = new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .build();

        final List<DataPoint> dataPoints = cloudClient.executeRequest(request);

        assertThat(dataPoints).isNotNull();
    }

    @Test
    public void keyDataPointTest() {
        final RestRequest<String> request = new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .withKey("QUOTE-CLOSE")
                .build();

        final String response = cloudClient.executeRequest(request);

        assertThat(response).isNotNull();
    }

}
