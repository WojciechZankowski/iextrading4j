package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Intraday;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractChartRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class IntradayRequestBuilder extends AbstractChartRequestBuilder<List<Intraday>,
        IntradayRequestBuilder> implements IEXCloudV1RestRequest<List<Intraday>> {

    public IntradayRequestBuilder withChartIEXOnly() {
        this.queryParameters.put("chartIEXOnly", Boolean.TRUE.toString());
        return this;
    }

    @Override
    public RestRequest<List<Intraday>> build() {
        return RestRequestBuilder.<List<Intraday>>builder()
                .withPath("/stock/{symbol}/intraday-prices")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<Intraday>>() {})
                .addQueryParam(this.queryParameters)
                .build();
    }
}
