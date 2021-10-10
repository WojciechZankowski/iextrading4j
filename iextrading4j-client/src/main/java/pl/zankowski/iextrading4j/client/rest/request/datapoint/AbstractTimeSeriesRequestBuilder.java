package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class AbstractTimeSeriesRequestBuilder<R, B extends IRestRequestBuilder<R>> implements IEXCloudV1RestRequest<R> {

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
    private final GenericType<R> responseType;
    private String key;
    private String subKey;

    protected AbstractTimeSeriesRequestBuilder(final String id, final GenericType<R> responseType) {
        this.id = id;
        this.responseType = responseType;
    }

    public B withFrom(final LocalDate from) {
        queryParameters.put(FROM_PARAM_NAME, IEX_DATE_FORMATTER.format(from));
        return (B) this;
    }

    public B withTo(final LocalDate to) {
        queryParameters.put(TO_PARAM_NAME, IEX_DATE_FORMATTER.format(to));
        return (B) this;
    }

    protected B withOn(final LocalDate on) {
        queryParameters.put(ON_PARAM_NAME, IEX_DATE_FORMATTER.format(on));
        return (B) this;
    }

    public B withLast(final int last) {
        queryParameters.put(LAST_PARAM_NAME, String.valueOf(last));
        return (B) this;
    }

    public B withFirst(final int first) {
        queryParameters.put(FIRST_PARAM_NAME, String.valueOf(first));
        return (B) this;
    }

    public B withRange(final TimeSeriesRange range) {
        queryParameters.put(RANGE_PARAM_NAME, range.getCode());
        return (B) this;
    }

    public B withRange(final int number, final TimeSeriesRangeUnit unit) {
        queryParameters.put(RANGE_PARAM_NAME, number + unit.getCode());
        return (B) this;
    }

    public B withCalendar(final boolean state) {
        queryParameters.put(CALENDAR_PARAM_NAME, String.valueOf(state));
        return (B) this;
    }

    protected B withLimit(final int limit) {
        queryParameters.put(LIMIT_PARAM_NAME, String.valueOf(limit));
        return (B) this;
    }

    protected B withUpdated(final boolean state) {
        queryParameters.put(UPDATED_PARAM_NAME, String.valueOf(state));
        return (B) this;
    }

    protected B withSubattribute(final String subattribute) {
        queryParameters.put(SUBATTRIBUTE_PARAM_NAME, subattribute);
        return (B) this;
    }

    protected B withSubattribute(final String keyName, final String value) {
        queryParameters.put(SUBATTRIBUTE_PARAM_NAME, keyName + "|" + value);
        return (B) this;
    }

    protected B withDateField(final String dateField) {
        queryParameters.put(DATE_FIELD_PARAM_NAME, dateField);
        return (B) this;
    }

    protected B withKey(final String key) {
        this.key = key;
        return (B) this;
    }

    protected B withSubKey(final String subKey) {
        this.subKey = subKey;
        return (B) this;
    }

    @Override
    public RestRequest<R> build() {
        if (subKey != null) {
            return RestRequestBuilder.<R>builder()
                    .withPath("/time-series/{id}/{key}/{subKey}")
                    .addPathParam("id", id)
                    .addPathParam("key", key)
                    .addPathParam("subKey", subKey).get()
                    .withResponse(responseType)
                    .addQueryParam(queryParameters)
                    .build();
        }
        if (key != null) {
            return RestRequestBuilder.<R>builder()
                    .withPath("/time-series/{id}/{key}")
                    .addPathParam("id", id)
                    .addPathParam("key", key).get()
                    .withResponse(responseType)
                    .addQueryParam(queryParameters)
                    .build();
        }
        return RestRequestBuilder.<R>builder()
                .withPath("/time-series/{id}")
                .addPathParam("id", id).get()
                .withResponse(responseType)
                .addQueryParam(queryParameters)
                .build();
    }

}
