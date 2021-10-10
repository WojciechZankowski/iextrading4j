package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Ownership;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class InstitutionalOwnershipRequestBuilder extends AbstractStocksRequestBuilder<List<Ownership>,
        InstitutionalOwnershipRequestBuilder> implements IEXCloudV1RestRequest<List<Ownership>> {

    @Override
    public RestRequest<List<Ownership>> build() {
        return RestRequestBuilder.<List<Ownership>>builder()
                .withPath("/stock/{symbol}/institutional-ownership")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<Ownership>>() {
                })
                .build();
    }

}
