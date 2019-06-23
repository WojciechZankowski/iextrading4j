package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

public class LastSseRequestBuilder extends AbstractSymbolSseRequestBuilder<LastTrade, LastSseRequestBuilder> {

    @Override
    public SseRequest<LastTrade> build() {
        return SseRequestBuilder.<LastTrade>builder()
                .withPath("/last")
                .withResponse(LastTrade.class)
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
