package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SecurityEventSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<SecurityEvent>>,
        SecurityEventSseRequestBuilder> {

    public SecurityEventSseRequestBuilder() {
        this.addChannel(DeepChannel.SECURITY_EVENT);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<SecurityEvent>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<SecurityEvent>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<SecurityEvent>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
