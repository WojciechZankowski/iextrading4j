package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class SplitsRequestBuilder extends AbstractStocksRequestBuilder<ArrayList<Split>, SplitsRequestBuilder> {

    private SplitsRange splitsRange = SplitsRange.ONE_MONTH;

    public SplitsRange getSplitsRange() {
        return splitsRange;
    }

    public SplitsRequestBuilder withSplitsRange(final SplitsRange splitsRange) {
        this.splitsRange = splitsRange;
        return this;
    }

    @Override
    public RestRequest<ArrayList<Split>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/splits/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", getSplitsRange().getCode()).get()
                .withResponse(new GenericType<ArrayList<Split>>() {})
                .build();
    }

}
