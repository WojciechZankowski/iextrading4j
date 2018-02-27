package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class OhlcRequestBuilder extends AbstractStocksRequestBuilder<Ohlc, OhlcRequestBuilder> {

    @Override
    public RestRequest<Ohlc> build() {
        return RestRequestBuilder.<Ohlc>builder()
                .withPath("/stock/{symbol}/ohlc")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Ohlc.class)
                .build();
    }
}
