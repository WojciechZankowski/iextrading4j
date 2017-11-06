package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class ListRequestBuilder implements IRestRequestBuilder<List<Quote>> {

    private ListType listType;

    public ListType getListType() {
        return listType;
    }

    public ListRequestBuilder withListType(final ListType listType) {
        this.listType = listType;
        return this;
    }

    @Override
    public RestRequest<List<Quote>> build() {
        return RestRequestBuilder.<List<Quote>>builder()
                .withPath("/stock/market/list/{type}")
                .addPathParam("type", getListType().name().toLowerCase()).get()
                .withResponse(new GenericType<List<Quote>>() {})
                .build();
    }

}
