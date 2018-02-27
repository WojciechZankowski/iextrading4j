package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ShortInterestRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final LocalDate date = LocalDate.of(2017, 5, 5);

        final RestRequest<List<ShortInterest>> request = new ShortInterestRequestBuilder()
                .withDate(date)
                .withSymbol("aapl")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/short-interest/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ShortInterest>>() {});
        assertThat(request.getPathParams()).contains(entry("date", "20170505"), entry("symbol", "aapl"));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithMarket() {
        final RestRequest<List<ShortInterest>> request = new ShortInterestRequestBuilder()
                .withMarket()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/short-interest/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ShortInterest>>() {});
        assertThat(request.getPathParams()).contains(entry("date", ""), entry("symbol", "market"));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithSample() {
        final RestRequest<List<ShortInterest>> request = new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/short-interest/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ShortInterest>>() {});
        assertThat(request.getPathParams()).contains(entry("date", "sample"), entry("symbol", "market"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
