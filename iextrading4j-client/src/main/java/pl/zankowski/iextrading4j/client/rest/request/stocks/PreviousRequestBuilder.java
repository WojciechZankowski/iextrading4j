package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

public class PreviousRequestBuilder extends AbstractStocksRequestBuilder<BarData, PreviousRequestBuilder>
        implements IEXApiRestRequest<BarData> {

    @Override
    public RestRequest<BarData> build() {
        return RestRequestBuilder.<BarData>builder()
                .withPath("/stock/{symbol}/previous")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(BarData.class)
                .build();
    }

}
