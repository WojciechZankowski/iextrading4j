package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.InsiderTransaction;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class InsiderTransactionRequestBuilder extends AbstractStocksRequestBuilder<List<InsiderTransaction>,
        InsiderTransactionRequestBuilder> implements IEXCloudV1RestRequest<List<InsiderTransaction>> {

    @Override
    public RestRequest<List<InsiderTransaction>> build() {
        return RestRequestBuilder.<List<InsiderTransaction>>builder()
                .withPath("/stock/{symbol}/insider-transactions")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<InsiderTransaction>>() {})
                .build();
    }

}
