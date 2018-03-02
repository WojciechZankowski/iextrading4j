package pl.zankowski.iextrading4j.client.rest.request.stocks;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.ISO_DATE_FORMATTER;

public class ChartRequestBuilder extends AbstractStocksRequestBuilder<List<Chart>, ChartRequestBuilder> {

    private static final String SYMBOL_PARAM_NAME = "symbol";

    private final Map<String, String> queryParameters = Maps.newHashMap();

    private LocalDate date;
    private ChartRange chartRange;

    public ChartRequestBuilder withChartReset() {
        this.queryParameters.put("chartReset", Boolean.TRUE.toString());
        return this;
    }

    public ChartRequestBuilder withChartSimplify() {
        this.queryParameters.put("chartSimplify", Boolean.TRUE.toString());
        return this;
    }

    public ChartRequestBuilder withChartInterval(final Integer interval) {
        this.queryParameters.put("chartInterval", String.valueOf(interval));
        return this;
    }

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
                .withPath("/stock/{symbol}/chart")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<List<Chart>>() {})
                .addQueryParam(queryParameters)
                .build();
    }

    private RestRequest<List<Chart>> requestWithRange() {
        return RestRequestBuilder.<List<Chart>>builder()
                .withPath("/stock/{symbol}/chart/{range}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam("range", getChartRange().getCode()).get()
                .withResponse(new GenericType<List<Chart>>() {})
                .addQueryParam(queryParameters)
                .build();
    }

    private RestRequest<List<Chart>> requestWithDate() {
        return RestRequestBuilder.<List<Chart>>builder()
                .withPath("/stock/{symbol}/chart/date/{date}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam("date", ISO_DATE_FORMATTER.format(date)).get()
                .withResponse(new GenericType<List<Chart>>() {})
                .addQueryParam(queryParameters)
                .build();
    }

}
