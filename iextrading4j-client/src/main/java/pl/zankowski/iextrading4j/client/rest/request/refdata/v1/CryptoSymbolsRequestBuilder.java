package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import javax.ws.rs.core.GenericType;
import pl.zankowski.iextrading4j.api.refdata.v1.CryptoSymbols;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import java.util.List;

public class CryptoSymbolsRequestBuilder extends AbstractRequestFilterBuilder<List<CryptoSymbols>, CryptoSymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<List<CryptoSymbols>> {

    @Override
    public RestRequest<List<CryptoSymbols>> build() {
        return RestRequestBuilder.<List<CryptoSymbols>>builder()
                .withPath("/ref-data/crypto/symbols").get()
                .withResponse(new GenericType<List<CryptoSymbols>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
