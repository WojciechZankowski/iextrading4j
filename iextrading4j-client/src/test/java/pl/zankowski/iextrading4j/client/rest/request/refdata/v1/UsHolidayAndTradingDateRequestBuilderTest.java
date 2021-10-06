package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.HolidayAndTradingDate;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class UsHolidayAndTradingDateRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateUsHolidayAndTradingRequest() {
        final DateType type = DateType.TRADE;
        final DateDirection direction = DateDirection.NEXT;

        final RestRequest<List<HolidayAndTradingDate>> request = new UsHolidayAndTradingDateRequestBuilder()
                .withType(type)
                .withDirection(direction)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/us/dates/{type}/{direction}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HolidayAndTradingDate>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("type", type.name().toLowerCase()),
                entry("direction", direction.name().toLowerCase()));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateUsHolidayAndTradingWithLastRequest() {
        final DateType type = DateType.TRADE;
        final DateDirection direction = DateDirection.NEXT;
        final Integer last = 10;

        final RestRequest<List<HolidayAndTradingDate>> request = new UsHolidayAndTradingDateRequestBuilder()
                .withType(type)
                .withDirection(direction)
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/us/dates/{type}/{direction}/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HolidayAndTradingDate>>() {
        });
        assertThat(request.getPathParams()).contains(entry("type", type.name().toLowerCase()),
                entry("direction", direction.name().toLowerCase()), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateUsHolidayAndTradingWithLastAndStartDateRequest() {
        final DateType type = DateType.TRADE;
        final DateDirection direction = DateDirection.NEXT;
        final Integer last = 10;
        final LocalDate startDate = LocalDate.of(2019, 5, 30);

        final RestRequest<List<HolidayAndTradingDate>> request = new UsHolidayAndTradingDateRequestBuilder()
                .withType(type)
                .withDirection(direction)
                .withLast(last)
                .withStartDate(startDate)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/us/dates/{type}/{direction}/{last}/{startDate}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HolidayAndTradingDate>>() {
        });
        assertThat(request.getPathParams()).contains(entry("type", type.name().toLowerCase()),
                entry("direction", direction.name().toLowerCase()), entry("last", String.valueOf(last)),
                entry("startDate", "20190530"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
