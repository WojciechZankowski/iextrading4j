package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class TradesSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<Trade>,
        TradesSseRequestBuilder> {

    public TradesSseRequestBuilder() {
        this.addChannel(DeepChannel.TRADES);
    }

    @Override
    public SseRequest<DeepAsyncResponse<Trade>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<Trade>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<Trade>>() {
                })
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("channels", getChannels())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }

}
