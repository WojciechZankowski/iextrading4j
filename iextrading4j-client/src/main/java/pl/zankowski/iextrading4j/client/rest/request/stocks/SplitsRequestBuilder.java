package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class SplitsRequestBuilder extends AbstractStocksRequestBuilder<List<Split>, SplitsRequestBuilder> {

    private SplitsRange splitsRange = SplitsRange.ONE_MONTH;

    public SplitsRange getSplitsRange() {
        return splitsRange;
    }

    public SplitsRequestBuilder withSplitsRange(final SplitsRange splitsRange) {
        this.splitsRange = splitsRange;
        return this;
    }

    @Override
    public RestRequest<List<Split>> build() {
        return RestRequestBuilder.<List<Split>>builder()
                .withPath("/stock/{symbol}/splits/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", getSplitsRange().getCode()).get()
                .withResponse(new GenericType<List<Split>>() {})
                .build();
    }

}
