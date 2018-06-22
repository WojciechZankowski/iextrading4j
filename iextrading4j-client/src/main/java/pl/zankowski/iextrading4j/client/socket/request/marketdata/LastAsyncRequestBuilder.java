package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;

public class LastAsyncRequestBuilder extends AbstractSymbolAsyncRequestBuilder<LastTrade, LastAsyncRequestBuilder> {

    @Override
    public SocketRequest<LastTrade> build() {
        return SocketRequestBuilder.<LastTrade>builder()
                .withPath("/last")
                .withResponse(new TypeReference<LastTrade>() {})
                .withParam(getSymbol())
                .build();
    }
}
