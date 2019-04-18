package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Estimates;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class EstimatesRequestBuilder extends AbstractLastStocksRequestBuilder<Estimates, EstimatesRequestBuilder>
        implements IEXCloudV1RestRequest<Estimates> {

    @Override
    RestRequest<Estimates> request() {
        return RestRequestBuilder.<Estimates>builder()
                .withPath("/stock/{symbol}/estimates")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(Estimates.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    RestRequest<Estimates> requestWithLast() {
        return RestRequestBuilder.<Estimates>builder()
                .withPath("/stock/{symbol}/estimates/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(Estimates.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
