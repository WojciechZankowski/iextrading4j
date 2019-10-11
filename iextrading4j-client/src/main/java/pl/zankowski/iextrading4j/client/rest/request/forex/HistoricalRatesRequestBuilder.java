package pl.zankowski.iextrading4j.client.rest.request.forex;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.forex.HistoricalCurrencyRate;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AbstractMarketDataRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class HistoricalRatesRequestBuilder extends AbstractMarketDataRequestBuilder<List<List<HistoricalCurrencyRate>>,
        HistoricalRatesRequestBuilder> {

    public static final DateTimeFormatter IEX_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final String FROM_PARAM_NAME = "from";
    private static final String TO_PARAM_NAME = "to";
    private static final String ON_PARAM_NAME = "on";
    private static final String LAST_PARAM_NAME = "last";
    private static final String FIRST_PARAM_NAME = "first";

    private final Map<String, String> queryParams = Maps.newHashMap();

    public HistoricalRatesRequestBuilder withFrom(final LocalDate from) {
        queryParams.put(FROM_PARAM_NAME, IEX_DATE_FORMATTER.format(from));
        return this;
    }

    public HistoricalRatesRequestBuilder withTo(final LocalDate to) {
        queryParams.put(TO_PARAM_NAME, IEX_DATE_FORMATTER.format(to));
        return this;
    }

    public HistoricalRatesRequestBuilder withOn(final LocalDate on) {
        queryParams.put(ON_PARAM_NAME, IEX_DATE_FORMATTER.format(on));
        return this;
    }

    public HistoricalRatesRequestBuilder withLast(final int last) {
        queryParams.put(LAST_PARAM_NAME, String.valueOf(last));
        return this;
    }

    public HistoricalRatesRequestBuilder withFirst(final int first) {
        queryParams.put(FIRST_PARAM_NAME, String.valueOf(first));
        return this;
    }

    @Override
    public RestRequest<List<List<HistoricalCurrencyRate>>> build() {
        return RestRequestBuilder.<List<List<HistoricalCurrencyRate>>>builder()
                .withPath("/fx/historical").get()
                .withResponse(new GenericType<List<List<HistoricalCurrencyRate>>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(queryParams)
                .build();
    }
}
