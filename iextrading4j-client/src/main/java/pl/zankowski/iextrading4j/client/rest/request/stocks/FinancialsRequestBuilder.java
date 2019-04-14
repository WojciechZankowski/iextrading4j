package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Financials;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class FinancialsRequestBuilder extends AbstractStocksRequestBuilder<Financials, FinancialsRequestBuilder>
        implements IEXApiRestRequest<Financials>, IEXCloudV1RestRequest<Financials> {

    @Override
    public RestRequest<Financials> build() {
        return RestRequestBuilder.<Financials>builder()
                .withPath("/stock/{symbol}/financials")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Financials.class)
                .build();
    }

}
