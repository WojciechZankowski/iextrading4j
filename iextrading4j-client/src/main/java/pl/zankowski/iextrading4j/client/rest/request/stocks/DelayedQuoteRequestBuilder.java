package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class DelayedQuoteRequestBuilder extends AbstractStocksRequestBuilder<DelayedQuote, DelayedQuoteRequestBuilder> {

    @Override
    public RestRequest<DelayedQuote> build() {
        return RestRequestBuilder.<DelayedQuote>builder()
                .withPath("/stock/{symbol}/delayed-quote")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(DelayedQuote.class)
                .build();
    }

}
