package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

public class TodayEarningsRequestBuilder implements IRestRequestBuilder<TodayEarnings> {

    @Override
    public RestRequest<TodayEarnings> build() {
        return RestRequestBuilder.<TodayEarnings>builder()
                .withPath("/stock/market/today-earnings").get()
                .withResponse(TodayEarnings.class)
                .build();
    }

}
