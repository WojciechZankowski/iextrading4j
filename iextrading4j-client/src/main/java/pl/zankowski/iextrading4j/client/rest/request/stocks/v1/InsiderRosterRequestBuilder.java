package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.InsiderRoster;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class InsiderRosterRequestBuilder extends AbstractStocksRequestBuilder<List<InsiderRoster>,
        InsiderRosterRequestBuilder> implements IEXCloudV1RestRequest<List<InsiderRoster>> {

    @Override
    public RestRequest<List<InsiderRoster>> build() {
        return RestRequestBuilder.<List<InsiderRoster>>builder()
                .withPath("/stock/{symbol}/insider-roster")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<InsiderRoster>>() {})
                .build();
    }

}
