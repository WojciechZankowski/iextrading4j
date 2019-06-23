package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class SecurityEventSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<SecurityEvent>,
        SecurityEventSseRequestBuilder> {

    public SecurityEventSseRequestBuilder() {
        this.addChannel(DeepChannel.SECURITY_EVENT);
    }

    @Override
    public SseRequest<DeepAsyncResponse<SecurityEvent>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<SecurityEvent>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<SecurityEvent>>() {
                })
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("channels", getChannels())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }

}
