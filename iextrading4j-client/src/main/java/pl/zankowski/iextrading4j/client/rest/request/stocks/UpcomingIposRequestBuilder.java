package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Ipos;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

public class UpcomingIposRequestBuilder implements IRestRequestBuilder<Ipos> {

    @Override
    public RestRequest<Ipos> build() {
        return RestRequestBuilder.<Ipos>builder()
                .withPath("/stock/market/upcoming-ipos").get()
                .withResponse(Ipos.class)
                .build();
    }

}
