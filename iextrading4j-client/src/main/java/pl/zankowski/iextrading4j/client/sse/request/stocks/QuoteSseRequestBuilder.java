package pl.zankowski.iextrading4j.client.sse.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class QuoteSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<Quote>, QuoteSseRequestBuilder> {

    private QuoteInterval quoteInterval;
    private boolean noUTP;

    public QuoteSseRequestBuilder withQuoteInterval(final QuoteInterval quoteInterval) {
        this.quoteInterval = quoteInterval;
        return this;
    }
    
    public QuoteSseRequestBuilder withNoUTP() {
    	this.noUTP = true;
    	return this;
    }

    @Override
    public SseRequest<List<Quote>> build() {
        return SseRequestBuilder.<List<Quote>>builder()
                .withPath(noUTP ? "/stocksUSNoUTP{interval}" : "/stocksUS{interval}")
                .addPathParam("interval", quoteInterval.getName())
                .withResponse(new GenericType<List<Quote>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
