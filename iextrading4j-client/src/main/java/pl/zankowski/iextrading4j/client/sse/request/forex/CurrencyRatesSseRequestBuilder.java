package pl.zankowski.iextrading4j.client.sse.request.forex;

import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.stocks.QuoteInterval;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CurrencyRatesSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CurrencyRate>,
        CurrencyRatesSseRequestBuilder> {

    private QuoteInterval quoteInterval = QuoteInterval.ONE_MINUTE;

    public CurrencyRatesSseRequestBuilder withQuoteInterval(final QuoteInterval quoteInterval) {
        this.quoteInterval = quoteInterval;
        return this;
    }

    @Override
    public SseRequest<List<CurrencyRate>> build() {
        return SseRequestBuilder.<List<CurrencyRate>>builder()
                .withPath("/forex{interval}")
                .addPathParam("interval", quoteInterval.getName())
                .withResponse(new GenericType<List<CurrencyRate>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
