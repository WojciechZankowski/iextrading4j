package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.BarData;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class PreviousRequestBuilder extends AbstractStocksRequestBuilder<BarData, PreviousRequestBuilder>
        implements IEXCloudV1RestRequest<BarData> {

    @Override
    public RestRequest<BarData> build() {
        return RestRequestBuilder.<BarData>builder()
                .withPath("/stock/{symbol}/previous")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(BarData.class)
                .build();
    }
}
