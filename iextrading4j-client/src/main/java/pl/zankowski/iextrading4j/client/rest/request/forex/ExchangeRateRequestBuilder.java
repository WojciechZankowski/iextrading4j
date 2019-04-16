package pl.zankowski.iextrading4j.client.rest.request.forex;

import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;

public class ExchangeRateRequestBuilder implements IEXCloudV1RestRequest<ExchangeRate> {

    private Pair pair;

    public ExchangeRateRequestBuilder withPair(final Pair pair) {
        this.pair = pair;
        return this;
    }

    @Override
    public RestRequest<ExchangeRate> build() {
        return RestRequestBuilder.<ExchangeRate>builder()
                .withPath("/fx/rate/{from}/{to}")
                .addPathParam("from", pair.getFrom())
                .addPathParam("to", pair.getTo()).get()
                .withResponse(new GenericType<ExchangeRate>() {})
                .build();
    }

}
