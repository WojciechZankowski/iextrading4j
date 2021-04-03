package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.datapoint.TimeSeriesMetadata;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TimeSeriesRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<TimeSeriesMetadata>> request = new TimeSeriesRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<TimeSeriesMetadata>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateRequestWithParameters() {
        final RestRequest<List<Map<String, String>>> request = new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withSubKey("10-Q")
                .withRange(TimeSeriesRange.LAST_QUARTER)
                .withCalendar(true)
                .withLimit(3)
                .withFrom(LocalDate.of(2019, 11, 2))
                .withTo(LocalDate.of(2019, 11, 3))
                .withOn(LocalDate.of(2019, 11, 4))
                .withLast(4)
                .withFirst(3)
                .withUpdated(true)
                .withSubattribute("test")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series/{id}/{key}/{subKey}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Map<String, String>>>() {});
        assertThat(request.getPathParams()).contains(entry("id", "REPORTED_FINANCIALS"), entry("key", "AAPL"),
                entry("subKey", "10-Q"));
        assertThat(request.getQueryParams()).contains(entry("range", "last-quarter"), entry("calendar", "true"),
                entry("limit", "3"), entry("from", "2019-11-02"), entry("to", "2019-11-03"), entry("on", "2019-11-04"),
                entry("last", "4"), entry("first", "3"), entry("updated", "true"), entry("subattribute", "test"));
    }

    @Test
    void shouldSuccessfullyCreateRequestWithSpecialRange() {
        final RestRequest<List<Map<String, String>>> request = new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withSubKey("10-Q")
                .withRange(4, TimeSeriesRangeUnit.QUARTER)
                .withSubattribute("key", "value")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series/{id}/{key}/{subKey}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Map<String, String>>>() {});
        assertThat(request.getPathParams()).contains(entry("id", "REPORTED_FINANCIALS"), entry("key", "AAPL"),
                entry("subKey", "10-Q"));
        assertThat(request.getQueryParams()).contains(entry("range", "4q"), entry("subattribute", "key|value"));
    }

    @Test
    void shouldSuccessfullyCreateRequestWithoutSubkey() {
        final RestRequest<List<Map<String, String>>> request = new TimeSeriesRequestBuilder()
                .withId("REPORTED_FINANCIALS")
                .withKey("AAPL")
                .withRange(4, TimeSeriesRangeUnit.QUARTER)
                .withSubattribute("key", "value")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series/{id}/{key}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Map<String, String>>>() {});
        assertThat(request.getPathParams()).contains(entry("id", "REPORTED_FINANCIALS"), entry("key", "AAPL"));
        assertThat(request.getQueryParams()).contains(entry("range", "4q"), entry("subattribute", "key|value"));
    }

}
