package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;

public class TopsAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<TOPS, TopsAsyncRequestBuilder> {

    @Override
    public SocketRequest<TOPS> build() {
        return SocketRequestBuilder.<TOPS>builder()
                .withPath("/tops")
                .withResponse(new TypeReference<TOPS>() {})
                .withParam(getSymbol())
                .build();
    }
}
