package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class SymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, SymbolsRequestBuilder> {

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/symbols").get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }
}
