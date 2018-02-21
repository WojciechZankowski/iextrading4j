package pl.zankowski.iextrading4j.client.rest.request.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.NextDayExDate;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class NextDayExDateRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final LocalDate date = LocalDate.of(2017, 5, 5);

        final RestRequest<List<NextDayExDate>> request = new NextDayExDateRequestBuilder().withDate(date).build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/daily-list/next-day-ex-date/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<NextDayExDate>>() {});
        assertThat(request.getPathParams()).contains(entry("date", "20170505"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
