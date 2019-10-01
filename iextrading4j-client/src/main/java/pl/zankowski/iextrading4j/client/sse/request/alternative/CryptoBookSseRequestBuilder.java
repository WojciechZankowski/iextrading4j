package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.CryptoDetailedBook;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CryptoBookSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CryptoDetailedBook>,
        CryptoBookSseRequestBuilder> {

    @Override
    public SseRequest<List<CryptoDetailedBook>> build() {
        return SseRequestBuilder.<List<CryptoDetailedBook>>builder()
                .withPath("/cryptoBook")
                .withResponse(new GenericType<List<CryptoDetailedBook>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
