package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.api.refdata.v1.FxSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;

public class FxSymbolRequestBuilder extends AbstractRequestFilterBuilder<FxSymbol, FxSymbolRequestBuilder>
        implements IEXCloudV1RestRequest<FxSymbol> {

    @Override
    public RestRequest<FxSymbol> build() {
        return RestRequestBuilder.<FxSymbol>builder()
                .withPath("/ref-data/fx/symbols").get()
                .withResponse(new GenericType<FxSymbol>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
