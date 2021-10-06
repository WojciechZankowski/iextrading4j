package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Dividends;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

/**
 * Dividends (Basic)
 * <p>
 * Provides basic dividend data for US equities, ETFs, and Mutual Funds for the last 5 years. For 13+ years of
 * history, comprehensive data, and international dividends, use the Advanced Dividends endpoint.
 * </p>
 * https://iexcloud.io/docs/api/#dividends-basic
 */
public class DividendsRequestBuilder extends AbstractStocksRequestBuilder<List<Dividends>, DividendsRequestBuilder>
        implements IEXCloudV1RestRequest<List<Dividends>> {

    private DividendRange dividendRange = DividendRange.ONE_MONTH;

    DividendRange getDividendRange() {
        return dividendRange;
    }

    public DividendsRequestBuilder withDividendRange(final DividendRange dividendRange) {
        this.dividendRange = dividendRange;
        return this;
    }

    @Override
    public RestRequest<List<Dividends>> build() {
        return RestRequestBuilder.<List<Dividends>>builder()
                .withPath("/stock/{symbol}/dividends/{range}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("range", getDividendRange().getCode()).get()
                .withResponse(new GenericType<List<Dividends>>() {
                })
                .build();
    }

}
