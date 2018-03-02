package pl.zankowski.iextrading4j.client.socket.request.market;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.IAsyncRequestBuilder;

import java.util.List;

public class MarketAsyncRequestBuilder implements IAsyncRequestBuilder<List<MarketVolume>> {

    @Override
    public SocketRequest<List<MarketVolume>> build() {
        return SocketRequestBuilder.<List<MarketVolume>>builder()
                .withPath("/market")
                .withResponse(new TypeReference<List<MarketVolume>>() {})
                .build();
    }
}
