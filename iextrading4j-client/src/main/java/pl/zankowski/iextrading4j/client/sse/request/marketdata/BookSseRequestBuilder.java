package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;

import javax.ws.rs.core.GenericType;

public class BookSseRequestBuilder extends AbstractDeepSseRequestBuilder<DeepAsyncResponse<Book>,
        BookSseRequestBuilder> {

    public BookSseRequestBuilder() {
        this.addChannel(DeepChannel.BOOK);
    }

    @Override
    public SseRequest<DeepAsyncResponse<Book>> build() {
        return SseRequestBuilder.<DeepAsyncResponse<Book>>builder()
                .withPath("/deep")
                .withResponse(new GenericType<DeepAsyncResponse<Book>>() {
                })
                .addQueryParam(CHANNEL_PARAM, getChannels())
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
