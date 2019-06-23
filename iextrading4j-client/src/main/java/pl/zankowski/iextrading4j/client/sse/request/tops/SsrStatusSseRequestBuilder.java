package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class SsrStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<SsrStatus>,
        SsrStatusSseRequestBuilder> {

    public SsrStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.SSR_STATUS);
    }

    @Override
    public SseRequest<DeepAsyncResponse<SsrStatus>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<SsrStatus>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<SsrStatus>>() {
                })
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("channels", getChannels())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }
}
