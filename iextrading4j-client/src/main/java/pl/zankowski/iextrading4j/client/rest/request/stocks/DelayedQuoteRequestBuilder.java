package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class DelayedQuoteRequestBuilder extends AbstractStocksRequestBuilder<DelayedQuote, DelayedQuoteRequestBuilder> {

    @Override
    public RestRequest<DelayedQuote> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/delayed-quote")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<DelayedQuote>() {})
                .build();
    }

}
