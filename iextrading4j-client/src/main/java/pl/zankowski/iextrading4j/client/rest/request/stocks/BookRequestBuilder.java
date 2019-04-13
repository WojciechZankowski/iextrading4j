package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class BookRequestBuilder extends AbstractStocksRequestBuilder<Book, BookRequestBuilder>
        implements IEXApiRestRequest<Book>, IEXCloudV1RestRequest<Book> {

    @Override
    public RestRequest<Book> build() {
        return RestRequestBuilder.<Book>builder()
                .withPath("/stock/{symbol}/book")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Book.class)
                .build();
    }

}
