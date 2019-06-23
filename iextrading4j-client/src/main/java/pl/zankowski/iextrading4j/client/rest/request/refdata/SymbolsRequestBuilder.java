package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class SymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<ExchangeSymbol>, SymbolsRequestBuilder>
        implements IEXApiRestRequest<List<ExchangeSymbol>> {

    @Override
    public RestRequest<List<ExchangeSymbol>> build() {
        return RestRequestBuilder.<List<ExchangeSymbol>>builder()
                .withPath("/ref-data/symbols").get()
                .withResponse(new GenericType<List<ExchangeSymbol>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }
}
