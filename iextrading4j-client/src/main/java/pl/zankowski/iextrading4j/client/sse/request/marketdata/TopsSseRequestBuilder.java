package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

public class TopsSseRequestBuilder extends AbstractSymbolSseRequestBuilder<TOPS, TopsSseRequestBuilder> {

    @Override
    public SseRequest<TOPS> build() {
        return SseRequestBuilder.<TOPS>builder()
                .withPath("/tops")
                .withResponse(TOPS.class)
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
