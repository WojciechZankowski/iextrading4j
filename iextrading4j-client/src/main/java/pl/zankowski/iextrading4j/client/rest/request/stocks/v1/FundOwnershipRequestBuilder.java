package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.FundOwnership;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class FundOwnershipRequestBuilder extends AbstractStocksRequestBuilder<List<FundOwnership>,
        FundOwnershipRequestBuilder> implements IEXCloudV1RestRequest<List<FundOwnership>> {

    @Override
    public RestRequest<List<FundOwnership>> build() {
        return RestRequestBuilder.<List<FundOwnership>>builder()
                .withPath("/stock/{symbol}/fund-ownership")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<FundOwnership>>() {})
                .build();
    }

}
