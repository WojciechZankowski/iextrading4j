package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class IncomeStatementRequestBuilder extends AbstractLastStocksRequestBuilder<IncomeStatements,
        IncomeStatementRequestBuilder> implements IEXCloudV1RestRequest<IncomeStatements> {

    @Override
    RestRequest<IncomeStatements> request() {
        return RestRequestBuilder.<IncomeStatements>builder()
                .withPath("/stock/{symbol}/income")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(IncomeStatements.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    RestRequest<IncomeStatements> requestWithLast() {
        return RestRequestBuilder.<IncomeStatements>builder()
                .withPath("/stock/{symbol}/income/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(IncomeStatements.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
