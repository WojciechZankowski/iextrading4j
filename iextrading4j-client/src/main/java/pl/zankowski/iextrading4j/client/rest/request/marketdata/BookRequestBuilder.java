package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class BookRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, Book>, BookRequestBuilder> {

    @Override
    public RestRequest<Map<String, Book>> build() {
        return RestRequestBuilder.<Map<String, Book>>builder()
                .withPath("/deep/book").get()
                .withResponse(new GenericType<Map<String, Book>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
