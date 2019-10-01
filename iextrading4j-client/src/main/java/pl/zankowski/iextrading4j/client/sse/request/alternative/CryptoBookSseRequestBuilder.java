package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.CryptoBookEvent;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CryptoBookSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CryptoBookEvent>,
        CryptoBookSseRequestBuilder> {

    @Override
    public SseRequest<List<CryptoBookEvent>> build() {
        return SseRequestBuilder.<List<CryptoBookEvent>>builder()
                .withPath("/cryptoBook")
                .withResponse(new GenericType<List<CryptoBookEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
