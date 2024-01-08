package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.CryptoEvent;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CryptoEventSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CryptoEvent>,
        CryptoEventSseRequestBuilder> {

    @Override
    public SseRequest<List<CryptoEvent>> build() {
        return SseRequestBuilder.<List<CryptoEvent>>builder()
                .withPath("/cryptoEvents")
                .withResponse(new GenericType<List<CryptoEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }
}
