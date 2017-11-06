package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.IAsyncRequest;

public class TopsAsyncRequestBuilder implements IAsyncRequest<TOPS> {

    @Override
    public SocketRequest<TOPS> build() {
        return SocketRequestBuilder.<TOPS>builder()
                .withPath("/tops")
                .withResponse(TOPS.class)
                .build();
    }
}
