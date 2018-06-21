package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.DeepResult;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class DeepAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<DeepResult>,
        DeepAsyncRequestBuilder> {

    @Override
    public DeepAsyncRequestBuilder addChannel(final DeepChannel channel) {
        super.addChannel(channel);
        return this;
    }

    @Override
    public SocketRequest<DeepAsyncResponse<DeepResult>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<DeepResult>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<DeepResult>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
