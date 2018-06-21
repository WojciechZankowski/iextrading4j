package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class SecurityEventAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SecurityEvent>,
        SecurityEventAsyncRequestBuilder> {

    public SecurityEventAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SECURITY_EVENT);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SecurityEvent>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SecurityEvent>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SecurityEvent>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
