package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class AuctionSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<Auction>,
        AuctionSseRequestBuilder> {

    public AuctionSseRequestBuilder() {
        this.addChannel(DeepChannel.AUCTION);
    }

    @Override
    public SseRequest<DeepAsyncResponse<Auction>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<Auction>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<Auction>>() {})
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
