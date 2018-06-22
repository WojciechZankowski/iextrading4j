package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class SystemEventAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SystemEvent>,
        SystemEventAsyncRequestBuilder> {

    public SystemEventAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SYSTEM_EVENT);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SystemEvent>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SystemEvent>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SystemEvent>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
