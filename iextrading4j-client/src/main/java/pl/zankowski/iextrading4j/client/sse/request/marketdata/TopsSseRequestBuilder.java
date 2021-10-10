package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class TopsSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<TOPS>, TopsSseRequestBuilder> {

    @Override
    public SseRequest<List<TOPS>> build() {
        return SseRequestBuilder.<List<TOPS>>builder()
                .withPath("/tops")
                .withResponse(new GenericType<List<TOPS>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
