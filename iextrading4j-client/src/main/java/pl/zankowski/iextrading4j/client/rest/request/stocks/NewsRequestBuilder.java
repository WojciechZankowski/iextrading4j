package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.News;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class NewsRequestBuilder extends AbstractStocksRequestBuilder<ArrayList<News>, NewsRequestBuilder> {

    private int last = 10;

    public NewsRequestBuilder withLast(int last) {
        this.last = last;
        return this;
    }

    public NewsRequestBuilder withWorldNews() {
        return withSymbol("market");
    }

    @Override
    public RestRequest<ArrayList<News>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/news/last/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", String.valueOf(last)).get()
                .withResponse(new GenericType<ArrayList<News>>() {})
                .build();
    }

}
