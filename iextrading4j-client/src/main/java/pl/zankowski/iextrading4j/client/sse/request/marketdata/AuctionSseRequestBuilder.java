package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class AuctionSseRequestBuilder extends AbstractDeepSseRequestBuilder<List<DeepAsyncResponse<Auction>>,
        AuctionSseRequestBuilder> {

    public AuctionSseRequestBuilder() {
        this.addChannel(DeepChannel.AUCTION);
    }

    @Override
    public SseRequest<List<DeepAsyncResponse<Auction>>> build() {
        return SseRequestBuilder.<List<DeepAsyncResponse<Auction>>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<List<DeepAsyncResponse<Auction>>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
