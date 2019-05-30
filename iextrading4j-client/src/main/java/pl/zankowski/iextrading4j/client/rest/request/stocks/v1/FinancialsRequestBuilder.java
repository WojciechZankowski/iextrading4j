package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Financials;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class FinancialsRequestBuilder extends AbstractLastStocksRequestBuilder<Financials, FinancialsRequestBuilder>
        implements IEXCloudV1RestRequest<Financials> {


    @Override
    RestRequest<Financials> request() {
        return RestRequestBuilder.<Financials>builder()
                .withPath("/stock/{symbol}/financials")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Financials.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    RestRequest<Financials> requestWithLast() {
        return RestRequestBuilder.<Financials>builder()
                .withPath("/stock/{symbol}/financials/{last}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("last", String.valueOf(last)).get()
                .withResponse(Financials.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
