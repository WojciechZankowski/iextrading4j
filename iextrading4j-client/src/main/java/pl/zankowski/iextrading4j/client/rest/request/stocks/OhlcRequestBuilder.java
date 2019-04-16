package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class OhlcRequestBuilder extends AbstractStocksRequestBuilder<Ohlc, OhlcRequestBuilder>
        implements IEXApiRestRequest<Ohlc>, IEXCloudV1RestRequest<Ohlc> {

    @Override
    public RestRequest<Ohlc> build() {
        return RestRequestBuilder.<Ohlc>builder()
                .withPath("/stock/{symbol}/ohlc")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Ohlc.class)
                .build();
    }
}
