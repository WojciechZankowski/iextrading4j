package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class DelayedQuoteRequestBuilder extends AbstractStocksRequestBuilder<DelayedQuote, DelayedQuoteRequestBuilder>
        implements IEXCloudV1RestRequest<DelayedQuote> {

    @Override
    public RestRequest<DelayedQuote> build() {
        return RestRequestBuilder.<DelayedQuote>builder()
                .withPath("/stock/{symbol}/delayed-quote")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(DelayedQuote.class)
                .build();
    }

}
