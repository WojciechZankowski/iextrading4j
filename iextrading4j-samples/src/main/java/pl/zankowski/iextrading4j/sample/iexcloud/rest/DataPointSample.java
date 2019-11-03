package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.api.datapoint.TimeSeriesMetadata;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.DataPointsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.TimeSeriesRequestBuilder;

import java.util.List;
import java.util.Map;

public class DataPointSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final DataPointSample sampleSuite = new DataPointSample();

        sampleSuite.dataPointsSample();
        sampleSuite.keyDataPointSample();
        sampleSuite.keyTimeSeriesSample();

        // Broken dates in sandbox
        // sampleSuite.timeSeriesSample();
    }

    private void dataPointsSample() {
        final List<DataPoint> result = cloudClient.executeRequest(new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(result);
    }

    private void keyDataPointSample() {
        final String result = cloudClient.executeRequest(new DataPointsRequestBuilder()
                .withSymbol("AAPL")
                .withKey("EMPLOYEES")
                .build());
        System.out.println(result);
    }

    private void timeSeriesSample() {
        final List<TimeSeriesMetadata> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .build());
        System.out.println(result);
    }

    private void keyTimeSeriesSample() {
        final List<Map<String, String>> result = cloudClient.executeRequest(new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withSubKey("10-Q")
                .build());
        System.out.println(result);
    }

}
