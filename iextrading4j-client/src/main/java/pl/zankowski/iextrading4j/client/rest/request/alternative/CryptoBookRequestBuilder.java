package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;

public class CryptoBookRequestBuilder extends AbstractStocksRequestBuilder<Book, CryptoBookRequestBuilder>
        implements IEXCloudV1RestRequest<Book> {

    @Override
    public RestRequest<Book> build() {
        return RestRequestBuilder.<Book>builder()
                .withPath("/crypto/{symbol}/book")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<Book>() {})
                .build();
    }

}
