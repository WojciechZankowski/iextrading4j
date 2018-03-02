package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class ThresholdSecuritiesRequestBuilder extends AbstractStocksRequestBuilder<List<ThresholdSecurities>, ThresholdSecuritiesRequestBuilder> {

    private String date;

    public String getDate() {
        return date == null ? "" : date;
    }

    public ThresholdSecuritiesRequestBuilder withDate(final LocalDate date) {
        this.date = IEX_DATE_FORMATTER.format(date);
        return this;
    }

    public ThresholdSecuritiesRequestBuilder withSample() {
        this.date = "sample";
        return this;
    }

    public ThresholdSecuritiesRequestBuilder withMarket() {
        return withSymbol("market");
    }

    @Override
    public RestRequest<List<ThresholdSecurities>> build() {
        return RestRequestBuilder.<List<ThresholdSecurities>>builder()
                .withPath("/stock/{symbol}/threshold-securities/{date}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("date", getDate()).get()
                .withResponse(new GenericType<List<ThresholdSecurities>>() {})
                .build();
    }
}
