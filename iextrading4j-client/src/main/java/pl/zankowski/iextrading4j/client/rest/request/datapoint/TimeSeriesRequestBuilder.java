package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import pl.zankowski.iextrading4j.api.datapoint.TimeSeriesMetadata;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TimeSeriesRequestBuilder implements IEXCloudV1RestRequest<List<TimeSeriesMetadata>> {

    public KeyTimeSeriesRequestBuilder withId(final String id) {
        return new KeyTimeSeriesRequestBuilder(id);
    }

    @Override
    public RestRequest<List<TimeSeriesMetadata>> build() {
        return RestRequestBuilder.<List<TimeSeriesMetadata>>builder()
                .withPath("/time-series").get()
                .withResponse(new GenericType<List<TimeSeriesMetadata>>() {
                })
                .build();
    }

    public static class KeyTimeSeriesRequestBuilder extends AbstractTimeSeriesRequestBuilder<List<Map<String, String>>,
            KeyTimeSeriesRequestBuilder> {

        public KeyTimeSeriesRequestBuilder(final String id) {
            super(id, new GenericType<List<Map<String, String>>>() {
            });
        }

        public KeyTimeSeriesRequestBuilder withOn(final LocalDate on) {
            return super.withOn(on);
        }

        public KeyTimeSeriesRequestBuilder withLimit(final int limit) {
            return super.withLimit(limit);
        }

        public KeyTimeSeriesRequestBuilder withUpdated(final boolean state) {
            return super.withUpdated(state);
        }

        public KeyTimeSeriesRequestBuilder withSubattribute(final String subattribute) {
            return super.withSubattribute(subattribute);
        }

        public KeyTimeSeriesRequestBuilder withSubattribute(final String keyName, final String value) {
            return super.withSubattribute(keyName, value);
        }

        public KeyTimeSeriesRequestBuilder withDateField(final String dateField) {
            return super.withDateField(dateField);
        }

        public KeyTimeSeriesRequestBuilder withKey(final String key) {
            return super.withKey(key);
        }

        public KeyTimeSeriesRequestBuilder withSubKey(final String subKey) {
            return super.withSubKey(subKey);
        }

    }
}
