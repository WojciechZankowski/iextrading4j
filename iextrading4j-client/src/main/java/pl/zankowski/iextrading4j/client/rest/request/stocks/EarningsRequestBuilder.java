package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class EarningsRequestBuilder extends AbstractStocksRequestBuilder<Earnings, EarningsRequestBuilder>
        implements IEXCloudV1RestRequest<Earnings> {

    private Integer last;

    public EarningsRequestBuilder withLast(final int last) {
        this.last = last;
        return this;
    }

    RestRequest<Earnings> request() {
        return RestRequestBuilder.<Earnings>builder()
                .withPath("/stock/{symbol}/earnings")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Earnings.class)
                .build();
    }

    RestRequest<Earnings> requestWithLast() {
        return RestRequestBuilder.<Earnings>builder()
                .withPath("/stock/{symbol}/earnings")
                .addPathParam("last", String.valueOf(last))
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Earnings.class)
                .build();
    }

    @Override
    public RestRequest<Earnings> build() {
        if (last != null) {
            return requestWithLast();
        } else {
            return request();
        }
    }

}
