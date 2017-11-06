package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class PeersRequestBuilder extends AbstractStocksRequestBuilder<ArrayList<String>, PeersRequestBuilder> {

    @Override
    public RestRequest<ArrayList<String>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/peers")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<ArrayList<String>>() {})
                .build();
    }

}
