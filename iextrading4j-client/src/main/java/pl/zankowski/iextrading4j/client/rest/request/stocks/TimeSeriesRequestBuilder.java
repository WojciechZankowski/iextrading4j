package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class TimeSeriesRequestBuilder extends AbstractStocksRequestBuilder<List<TimeSeries>, TimeSeriesRequestBuilder> {

    @Override
    public RestRequest<List<TimeSeries>> build() {
        return RestRequestBuilder.<List<TimeSeries>>builder()
                .withPath("/stock/{symbol}/time-series")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<TimeSeries>>() {})
                .build();
    }

}
