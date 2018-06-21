package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class SsrStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<SsrStatus>,
        SsrStatusAsyncRequestBuilder> {

    public SsrStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.SSR_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<SsrStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<SsrStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<SsrStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
