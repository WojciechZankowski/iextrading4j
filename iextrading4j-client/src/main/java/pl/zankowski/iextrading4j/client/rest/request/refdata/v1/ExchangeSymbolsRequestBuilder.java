package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class ExchangeSymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, ExchangeSymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<List<ExchangeSymbol>> {

    private String exchange;

    public ExchangeSymbolsRequestBuilder withExchange(final String exchange) {
        this.exchange = exchange;
        return this;
    }

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/exchange/{exchange}/symbols")
                .addPathParam("exchange", exchange).get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }
}
