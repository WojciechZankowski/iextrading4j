package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CryptoRequestBuilder implements IEXApiRestRequest<List<Quote>> {

    @Override
    public RestRequest<List<Quote>> build() {
        return RestRequestBuilder.<List<Quote>>builder()
                .withPath("/stock/market/crypto").get()
                .withResponse(new GenericType<List<Quote>>() {})
                .build();
    }

}
