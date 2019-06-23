package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.DeepResult;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class DeepSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<DeepResult>,
        DeepSseRequestBuilder> {

    public DeepSseRequestBuilder() {
        this.addChannel(DeepChannel.DEEP);
    }

    @Override
    public SseRequest<DeepAsyncResponse<DeepResult>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<DeepResult>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<DeepResult>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}

