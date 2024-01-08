package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class TradesSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<Trade>>,
        TradesSseRequestBuilder> {

    public TradesSseRequestBuilder() {
        this.addChannel(DeepChannel.TRADES);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<Trade>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<Trade>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<Trade>>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
