package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChartRequestBuilder extends AbstractStocksRequestBuilder<List<Chart>, ChartRequestBuilder> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE;

    private LocalDate date;
    private ChartRange chartRange;

    public LocalDate getDate() {
        return date;
    }

    public ChartRequestBuilder withDate(final LocalDate date) {
        this.date = date;
        return this;
    }

    public ChartRange getChartRange() {
        return chartRange;
    }

    public ChartRequestBuilder withChartRange(final ChartRange chartRange) {
        this.chartRange = chartRange;
        return this;
    }

    @Override
    public RestRequest<List<Chart>> build() {
        if (chartRange != null) {
            return requestWithRange();
        } else if (date != null) {
            return requestWithDate();
        } else {
            return request();
        }
    }

    private RestRequest<List<Chart>> request() {
        return RestRequestBuilder.<List<Chart>>builder()
                .withPath("/stock/{symbol}/chart").get()
                .withResponse(new GenericType<List<Chart>>() {})
                .build();
    }

    private RestRequest<List<Chart>> requestWithRange() {
        return RestRequestBuilder.<List<Chart>>builder()
                .withPath("/stock/{symbol}/chart/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", getChartRange().getCode()).get()
                .withResponse(new GenericType<List<Chart>>() {})
                .build();
    }

    private RestRequest<List<Chart>> requestWithDate() {
        return RestRequestBuilder.<List<Chart>>builder()
                .withPath("/stock/{symbol}/chart/date/{date}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("date", DATE_TIME_FORMATTER.format(date)).get()
                .withResponse(new GenericType<List<Chart>>() {})
                .build();
    }

}
