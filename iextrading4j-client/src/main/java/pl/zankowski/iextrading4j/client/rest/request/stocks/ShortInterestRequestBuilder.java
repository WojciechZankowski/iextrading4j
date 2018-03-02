package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class ShortInterestRequestBuilder extends AbstractStocksRequestBuilder<List<ShortInterest>, ShortInterestRequestBuilder> {

    private String date;

    public String getDate() {
        return date == null ? "" : date;
    }

    public ShortInterestRequestBuilder withDate(final LocalDate date) {
        this.date = IEX_DATE_FORMATTER.format(date);
        return this;
    }

    public ShortInterestRequestBuilder withSample() {
        this.date = "sample";
        return this;
    }

    public ShortInterestRequestBuilder withMarket() {
        return withSymbol("market");
    }

    @Override
    public RestRequest<List<ShortInterest>> build() {
        return RestRequestBuilder.<List<ShortInterest>>builder()
                .withPath("/stock/{symbol}/short-interest/{date}")
                .addPathParam("symbol", getSymbol())
                .addPathParam("date", getDate()).get()
                .withResponse(new GenericType<List<ShortInterest>>() {})
                .build();
    }
}
