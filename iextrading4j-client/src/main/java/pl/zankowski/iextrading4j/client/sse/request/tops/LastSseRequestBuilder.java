package pl.zankowski.iextrading4j.client.sse.request.tops;

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
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }
}
