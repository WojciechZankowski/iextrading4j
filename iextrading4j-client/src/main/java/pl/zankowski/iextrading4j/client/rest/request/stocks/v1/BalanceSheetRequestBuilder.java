package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

/**
 * Balance Sheet
 * <p>
 * Pulls balance sheet data. Available quarterly or annually with the default being the last available quarter.
 * This data is currently only available for U.S. symbols.
 * </p>
 * https://iexcloud.io/docs/api/#balance-sheet
 */
public class BalanceSheetRequestBuilder extends AbstractLastStocksRequestBuilder<BalanceSheets, BalanceSheetRequestBuilder>
        implements IEXCloudV1RestRequest<BalanceSheets> {

    @Override
    protected RestRequest<BalanceSheets> request() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    protected RestRequest<BalanceSheets> requestWithLast() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

}
