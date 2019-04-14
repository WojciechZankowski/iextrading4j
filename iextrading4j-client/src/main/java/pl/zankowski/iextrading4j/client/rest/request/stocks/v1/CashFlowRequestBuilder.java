package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import java.util.Map;

public class CashFlowRequestBuilder extends AbstractStocksRequestBuilder<CashFlows, CashFlowRequestBuilder>
        implements IEXCloudV1RestRequest<CashFlows> {

    private final Map<String, String> queryParameters = Maps.newHashMap();
    private Integer last;

    public CashFlowRequestBuilder withLast(final int last) {
        this.last = last;
        return this;
    }

    public CashFlowRequestBuilder withPeriod(final Period period) {
        this.queryParameters.put("period", period.name().toLowerCase());
        return this;
    }

    public RestRequest<CashFlows> request() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

    public RestRequest<CashFlows> requestWithLast() {
        return RestRequestBuilder.<CashFlows>builder()
                .withPath("/stock/{symbol}/cash-flow/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(CashFlows.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    public RestRequest<CashFlows> build() {
        if (last != null) {
            return requestWithLast();
        } else {
            return request();
        }
    }
}
