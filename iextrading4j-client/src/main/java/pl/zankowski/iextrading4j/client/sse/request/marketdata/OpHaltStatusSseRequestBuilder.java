package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class OpHaltStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<OpHaltStatus>,
        OpHaltStatusSseRequestBuilder> {

    public OpHaltStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.OP_HALT_STATUS);
    }

    @Override
    public SseRequest<DeepAsyncResponse<OpHaltStatus>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<OpHaltStatus>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<OpHaltStatus>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
