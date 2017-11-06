package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Relevant;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class RelevantRequestBuilder extends AbstractStocksRequestBuilder<Relevant, RelevantRequestBuilder> {

    @Override
    public RestRequest<Relevant> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/relevant")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<Relevant>() {})
                .build();
    }

}
