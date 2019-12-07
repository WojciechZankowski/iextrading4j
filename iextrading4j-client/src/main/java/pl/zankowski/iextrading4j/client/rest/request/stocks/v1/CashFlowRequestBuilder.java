package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class CashFlowRequestBuilder extends AbstractLastStocksRequestBuilder<CashFlows, CashFlowRequestBuilder>
        implements IEXCloudV1RestRequest<CashFlows> {

    @Override
    protected RestRequest<CashFlows> request() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<CashFlows> requestWithLast() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
