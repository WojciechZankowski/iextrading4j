package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.DynamicChart;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class DynamicChartRequestBuilder extends AbstractChartRequestBuilder<DynamicChart, DynamicChartRequestBuilder> {

    @Override
    public RestRequest<DynamicChart> build() {
        return RestRequestBuilder.<DynamicChart>builder()
                .withPath("/stock/{symbol}/chart/dynamic")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(DynamicChart.class)
                .addQueryParam(getQueryParameters())
                .build();
    }
}
