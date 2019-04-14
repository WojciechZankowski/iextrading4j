package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.v1.Symbol;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class IEXSymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<Symbol>, SymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<List<Symbol>> {

    @Override
    public RestRequest<List<Symbol>> build() {
        return RestRequestBuilder.<List<Symbol>>builder()
                .withPath("/ref-data/iex/symbols").get()
                .withResponse(new GenericType<List<Symbol>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }
}
