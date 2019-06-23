package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class SystemEventSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<SystemEvent>,
        SystemEventSseRequestBuilder> {

    public SystemEventSseRequestBuilder() {
        this.addChannel(DeepChannel.SYSTEM_EVENT);
    }

    @Override
    public SseRequest<DeepAsyncResponse<SystemEvent>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<SystemEvent>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<SystemEvent>>() {
                })
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("channels", getChannels())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }

}
