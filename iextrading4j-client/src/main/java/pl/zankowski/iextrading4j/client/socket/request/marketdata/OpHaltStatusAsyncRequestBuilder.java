package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class OpHaltStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<OpHaltStatus>,
        OpHaltStatusAsyncRequestBuilder> {

    public OpHaltStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.OP_HALT_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<OpHaltStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<OpHaltStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<OpHaltStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
