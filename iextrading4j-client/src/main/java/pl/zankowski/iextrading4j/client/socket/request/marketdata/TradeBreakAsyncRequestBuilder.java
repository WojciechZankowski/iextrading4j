package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class TradeBreakAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Trade>,
        TradeBreakAsyncRequestBuilder> {

    public TradeBreakAsyncRequestBuilder() {
        super.addChannel(DeepChannel.TRADE_BREAK);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Trade>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Trade>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Trade>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
