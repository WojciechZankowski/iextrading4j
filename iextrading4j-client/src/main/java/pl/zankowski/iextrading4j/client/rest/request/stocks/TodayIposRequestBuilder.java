package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.TodayIpos;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class TodayIposRequestBuilder implements IEXCloudV1RestRequest<TodayIpos> {

    @Override
    public RestRequest<TodayIpos> build() {
        return RestRequestBuilder.<TodayIpos>builder()
                .withPath("/stock/market/today-ipos").get()
                .withResponse(TodayIpos.class)
                .build();
    }

}
