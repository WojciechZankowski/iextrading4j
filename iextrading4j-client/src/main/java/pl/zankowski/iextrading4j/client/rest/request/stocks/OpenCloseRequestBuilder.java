package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class OpenCloseRequestBuilder extends AbstractStocksRequestBuilder<Ohlc, OpenCloseRequestBuilder> {

    @Override
    public RestRequest<Ohlc> build() {
        return RestRequestBuilder.<Ohlc>builder()
                .withPath("/stock/{symbol}/open-close")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Ohlc.class)
                .build();
    }

}
