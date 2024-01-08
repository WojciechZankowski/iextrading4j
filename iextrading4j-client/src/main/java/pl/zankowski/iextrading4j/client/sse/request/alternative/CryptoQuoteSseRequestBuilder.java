package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CryptoQuoteSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<Quote>,
        CryptoQuoteSseRequestBuilder> {

    @Override
    public SseRequest<List<Quote>> build() {
        return SseRequestBuilder.<List<Quote>>builder()
                .withPath("/cryptoQuotes")
                .withResponse(new GenericType<List<Quote>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
