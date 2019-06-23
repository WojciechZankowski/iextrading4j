package pl.zankowski.iextrading4j.client.sse.request.tops;

import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class TradingStatusSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<TradingStatus>,
        TradingStatusSseRequestBuilder> {

    public TradingStatusSseRequestBuilder() {
        this.addChannel(DeepChannel.TRADING_STATUS);
    }

    @Override
    public SseRequest<DeepAsyncResponse<TradingStatus>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<TradingStatus>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<TradingStatus>>() {
                })
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("channels", getChannels())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }

}
