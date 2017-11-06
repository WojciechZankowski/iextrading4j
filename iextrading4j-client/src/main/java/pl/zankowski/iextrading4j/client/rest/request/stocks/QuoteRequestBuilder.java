package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class QuoteRequestBuilder extends AbstractStocksRequestBuilder<Quote, QuoteRequestBuilder> {

    private boolean displayPercent;

    public QuoteRequestBuilder withDisplayPercent() {
        this.displayPercent = true;
        return this;
    }

    @Override
    public RestRequest<Quote> build() {
        return RestRequestBuilder.<Quote>builder()
                .withPath("/stock/{symbol}/quote")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Quote.class)
                .addQueryParam("displayPercent", String.valueOf(displayPercent))
                .build();
    }
}
