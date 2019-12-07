package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.datapoint.TimeSeriesMetadata;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                .withResponse(new GenericType<List<TimeSeriesMetadata>>() {})
                .build();
    }

    public static class KeyTimeSeriesRequestBuilder implements IEXCloudV1RestRequest<List<Map<String, String>>> {

        public static final DateTimeFormatter IEX_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        private static final String RANGE_PARAM_NAME = "range";
        private static final String CALENDAR_PARAM_NAME = "calendar";
        private static final String LIMIT_PARAM_NAME = "limit";
        private static final String FROM_PARAM_NAME = "from";
        private static final String TO_PARAM_NAME = "to";
        private static final String ON_PARAM_NAME = "on";
        private static final String LAST_PARAM_NAME = "last";
        private static final String FIRST_PARAM_NAME = "first";
        private static final String UPDATED_PARAM_NAME = "updated";
        private static final String SUBATTRIBUTE_PARAM_NAME = "subattribute";
        private static final String DATE_FIELD_PARAM_NAME = "dateField";

        private final Map<String, String> queryParameters = Maps.newHashMap();

        private final String id;
        private String key;
        private String subKey;

        public KeyTimeSeriesRequestBuilder withFrom(final LocalDate from) {
            queryParameters.put(FROM_PARAM_NAME, IEX_DATE_FORMATTER.format(from));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withTo(final LocalDate to) {
            queryParameters.put(TO_PARAM_NAME, IEX_DATE_FORMATTER.format(to));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withOn(final LocalDate on) {
            queryParameters.put(ON_PARAM_NAME, IEX_DATE_FORMATTER.format(on));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withLast(final int last) {
            queryParameters.put(LAST_PARAM_NAME, String.valueOf(last));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withFirst(final int first) {
            queryParameters.put(FIRST_PARAM_NAME, String.valueOf(first));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withRange(final TimeSeriesRange range) {
            queryParameters.put(RANGE_PARAM_NAME, range.getCode());
            return this;
        }

        public KeyTimeSeriesRequestBuilder withRange(final int number, final TimeSeriesRangeUnit unit) {
            queryParameters.put(RANGE_PARAM_NAME, number + unit.getCode());
            return this;
        }

        public KeyTimeSeriesRequestBuilder withCalendar(final boolean state) {
            queryParameters.put(CALENDAR_PARAM_NAME, String.valueOf(state));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withLimit(final int limit) {
            queryParameters.put(LIMIT_PARAM_NAME, String.valueOf(limit));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withUpdated(final boolean state) {
            queryParameters.put(UPDATED_PARAM_NAME, String.valueOf(state));
            return this;
        }

        public KeyTimeSeriesRequestBuilder withSubattribute(final String subattribute) {
            queryParameters.put(SUBATTRIBUTE_PARAM_NAME, subattribute);
            return this;
        }

        public KeyTimeSeriesRequestBuilder withSubattribute(final String keyName, final String value) {
            queryParameters.put(SUBATTRIBUTE_PARAM_NAME, keyName + "|" + value);
            return this;
        }

        public KeyTimeSeriesRequestBuilder withDateField(final String dateField) {
            queryParameters.put(DATE_FIELD_PARAM_NAME, dateField);
            return this;
        }

        public KeyTimeSeriesRequestBuilder(final String id) {
            this.id = id;
        }

        public KeyTimeSeriesRequestBuilder withKey(final String key) {
            this.key = key;
            return this;
        }

        public KeyTimeSeriesRequestBuilder withSubKey(final String subKey) {
            this.subKey = subKey;
            return this;
        }

        @Override
        public RestRequest<List<Map<String, String>>> build() {
            if (subKey != null) {
                return RestRequestBuilder.<List<Map<String, String>>>builder()
                        .withPath("/time-series/{id}/{key}/{subKey}")
                        .addPathParam("id", id)
                        .addPathParam("key", key)
                        .addPathParam("subKey", subKey).get()
                        .withResponse(new GenericType<List<Map<String, String>>>() {})
                        .addQueryParam(queryParameters)
                        .build();
            }
            if (key != null) {
                return RestRequestBuilder.<List<Map<String, String>>>builder()
                        .withPath("/time-series/{id}/{key}")
                        .addPathParam("id", id)
                        .addPathParam("key", key).get()
                        .withResponse(new GenericType<List<Map<String, String>>>() {})
                        .addQueryParam(queryParameters)
                        .build();
            }
            return RestRequestBuilder.<List<Map<String, String>>>builder()
                    .withPath("/time-series/{id}")
                    .addPathParam("id", id).get()
                    .withResponse(new GenericType<List<Map<String, String>>>() {})
                    .addQueryParam(queryParameters)
                    .build();
        }

    }

}
