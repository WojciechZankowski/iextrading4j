package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

public class BookAsyncRequestBuilder extends AbstractDeepAsyncRequestBuilder<DeepAsyncResponse<Book>,
        BookAsyncRequestBuilder> {

    public BookAsyncRequestBuilder() {
        super.addChannel(DeepChannel.BOOK);
    }

    @Override
    public SocketRequest<DeepAsyncResponse<Book>> build() {
        return SocketRequestBuilder.<DeepAsyncResponse<Book>>builder()
                .withPath("/deep")
                .withResponse(new TypeReference<DeepAsyncResponse<Book>>() {})
                .withParam(getDeepParam())
                .build();
    }
}
