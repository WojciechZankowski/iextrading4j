package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TimeSeriesRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<TimeSeries>> request = new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/time-series");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<TimeSeries>>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", "aapl"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
