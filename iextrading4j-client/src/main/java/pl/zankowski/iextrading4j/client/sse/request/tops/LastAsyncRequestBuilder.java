package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

public class LastAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<LastTrade, LastAsyncRequestBuilder> {

    @Override
    public SseRequest<LastTrade> build() {
        return SseRequestBuilder.<LastTrade>builder()
                .withPath("/last")
                .withResponse(LastTrade.class)
                .addQueryParam("symbols", getSymbol())
                .build();
    }
}
