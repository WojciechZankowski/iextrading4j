package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class TradingStatusAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<TradingStatus>,
        TradingStatusAsyncRequestBuilder> {

    public TradingStatusAsyncRequestBuilder() {
        super.addChannel(DeepChannel.TRADING_STATUS);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<TradingStatus>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<TradingStatus>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<TradingStatus>>() {})
                .withParam(getDeepParam())
                .build();
    }

}
