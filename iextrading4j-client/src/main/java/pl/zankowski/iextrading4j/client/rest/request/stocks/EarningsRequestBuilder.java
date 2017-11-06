package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class EarningsRequestBuilder extends AbstractStocksRequestBuilder<Earnings, EarningsRequestBuilder> {

    @Override
    public RestRequest<Earnings> build() {
        return RestRequestBuilder.<Earnings>builder()
                .withPath("/stock/{symbol}/earnings")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Earnings.class)
                .build();
    }

}
