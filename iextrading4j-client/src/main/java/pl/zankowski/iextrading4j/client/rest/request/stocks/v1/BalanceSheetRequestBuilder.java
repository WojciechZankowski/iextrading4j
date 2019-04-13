package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import java.util.Map;

public class BalanceSheetRequestBuilder extends AbstractStocksRequestBuilder<BalanceSheets, BalanceSheetRequestBuilder>
        implements IEXCloudV1RestRequest<BalanceSheets> {

    private final Map<String, String> queryParameters = Maps.newHashMap();
    private Integer last;

    public BalanceSheetRequestBuilder withLast(final int last) {
        this.last = last;
        return this;
    }

    public BalanceSheetRequestBuilder withPeriod(final Period period) {
        this.queryParameters.put("period", period.name().toLowerCase());
        return this;
    }

    public RestRequest<BalanceSheets> request() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

    public RestRequest<BalanceSheets> requestWithLast() {
        return RestRequestBuilder.<BalanceSheets>builder()
                .withPath("/stock/{symbol}/balance-sheet/{last}")
                .addPathParam("last", String.valueOf(last))
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(BalanceSheets.class)
                .addQueryParam(queryParameters)
                .build();
    }

    @Override
    public RestRequest<BalanceSheets> build() {
        if (last != null) {
            return requestWithLast();
        } else {
            return request();
        }
    }

}
