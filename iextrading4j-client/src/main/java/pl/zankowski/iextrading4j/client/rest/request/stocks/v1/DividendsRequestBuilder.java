package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.Dividends;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;

import javax.ws.rs.core.GenericType;
import java.util.List;

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
