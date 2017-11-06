package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class BookRequestBuilder extends AbstractStocksRequestBuilder<Book, BookRequestBuilder> {

    @Override
    public RestRequest<Book> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/book")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<Book>() {})
                .build();
    }

}
