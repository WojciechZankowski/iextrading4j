package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ChartRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithRange() {
        final String symbol = "IBM";
        final ChartRange chartRange = ChartRange.ONE_DAY;

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChartRange(chartRange)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).contains(
                entry("range", chartRange.getCode()),
                entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithDate() {
        final String symbol = "IBM";

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withDate(LocalDate.of(2017, 5, 5))
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart/date/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(
                entry("date", "20170505"),
                entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChartReset() {
        final String symbol = "IBM";

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChartReset()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("chartReset", "true"));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChartSimplify() {
        final String symbol = "IBM";

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChartSimplify()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("chartSimplify", "true"));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChartInterval() {
        final String symbol = "IBM";
        final Integer chartInterval = 5;

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChartInterval(chartInterval)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("chartInterval", String.valueOf(chartInterval)));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChangeFromClose() {
        final String symbol = "IBM";

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChangeFromClose()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("changeFromClose", "true"));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChartLast() {
        final String symbol = "IBM";
        final Integer chartLast = 5;

        final RestRequest<List<Chart>> request = new ChartRequestBuilder()
                .withSymbol(symbol)
                .withChartLast(chartLast)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/chart");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Chart>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("chartLast", String.valueOf(chartLast)));
    }

}
