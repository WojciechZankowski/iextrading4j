package pl.zankowski.iextrading4j.client.rest.request.forex;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.forex.HistoricalCurrencyRate;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class HistoricalRatesRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<List<HistoricalCurrencyRate>>> request = new HistoricalRatesRequestBuilder()
                .withSymbol("USDGPB")
                .withFrom(LocalDate.of(2019, 10, 10))
                .withTo(LocalDate.of(2019, 10, 12))
                .withOn(LocalDate.of(2019, 10, 11))
                .withFirst(10)
                .withLast(5)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/fx/historical");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<List<HistoricalCurrencyRate>>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(
                entry("symbols", "USDGPB"),
                entry("from", "2019-10-10"),
                entry("to", "2019-10-12"),
                entry("on", "2019-10-11"),
                entry("last", "5"),
                entry("first", "10"));
    }

}
