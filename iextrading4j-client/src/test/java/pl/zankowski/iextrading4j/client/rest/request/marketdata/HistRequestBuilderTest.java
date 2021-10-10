package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HistRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateParameterizedRequest() {
        final LocalDate date = LocalDate.of(2017, 5, 5);

        final RestRequest<List<HIST>> request = new HistRequestBuilder()
                .withDate(date)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/hist");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HIST>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("date", "20170505"));
    }

    @Test
    void shouldThrowNullPointerExceptionWhenDateIsNull() {
        final LocalDate date = null;
        final HistRequestBuilder histRequestBuilder = new HistRequestBuilder();

        assertThrows(NullPointerException.class, () -> histRequestBuilder
                .withDate(date));
    }

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<Map<String, List<HIST>>> request = new HistRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/hist");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, List<HIST>>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
