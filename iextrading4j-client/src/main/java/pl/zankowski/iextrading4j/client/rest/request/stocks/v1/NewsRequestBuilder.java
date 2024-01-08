package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.News;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class NewsRequestBuilder extends AbstractStocksRequestBuilder<List<News>, NewsRequestBuilder>
        implements IEXCloudV1RestRequest<List<News>> {

    private int last = 10;

    public NewsRequestBuilder withLast(int last) {
        this.last = last;
        return this;
    }

    public NewsRequestBuilder withWorldNews() {
        return withSymbol("market");
    }

    @Override
    public RestRequest<List<News>> build() {
        return RestRequestBuilder.<List<News>>builder()
                .withPath("/stock/{symbol}/news/last/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", String.valueOf(last)).get()
                .withResponse(new GenericType<List<News>>() {})
                .build();
    }

}
