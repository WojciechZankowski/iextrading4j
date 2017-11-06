package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.OpenClose;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class OpenCloseRequestBuilder extends AbstractStocksRequestBuilder<OpenClose, OpenCloseRequestBuilder> {

    @Override
    public RestRequest<OpenClose> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/book")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<OpenClose>() {})
                .build();
    }

}
