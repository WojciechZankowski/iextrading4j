package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

public class TopsAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<TOPS, TopsAsyncRequestBuilder> {

    @Override
    public SseRequest<TOPS> build() {
        return SseRequestBuilder.<TOPS>builder()
                .withPath("/tops")
                .withResponse(TOPS.class)
                .addQueryParam("symbols", getSymbol())
                .build();
    }

}
