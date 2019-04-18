package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import java.util.Map;

public class BalanceSheetRequestBuilder extends AbstractLastStocksRequestBuilder<BalanceSheets, BalanceSheetRequestBuilder>
        implements IEXCloudV1RestRequest<BalanceSheets> {

    @Override
    RestRequest<BalanceSheets> request() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    RestRequest<BalanceSheets> requestWithLast() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
