package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class AuctionAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Auction>,
        AuctionAsyncRequestBuilder> {

    public AuctionAsyncRequestBuilder() {
        super.addChannel(DeepChannel.AUCTION);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Auction>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Auction>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Auction>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
