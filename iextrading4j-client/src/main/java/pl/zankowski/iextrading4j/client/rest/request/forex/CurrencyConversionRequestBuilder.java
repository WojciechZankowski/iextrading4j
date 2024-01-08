package pl.zankowski.iextrading4j.client.rest.request.forex;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.forex.CurrencyConversion;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AbstractMarketDataRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CurrencyConversionRequestBuilder extends AbstractMarketDataRequestBuilder<List<CurrencyConversion>,
        CurrencyConversionRequestBuilder> {

    private static final String AMOUNT_PARAM = "amount";

    private final Map<String, String> amountParams = Maps.newHashMap();

    public CurrencyConversionRequestBuilder withAmount(final BigDecimal amount) {
        amountParams.put(AMOUNT_PARAM, amount.toPlainString());
        return this;
    }

    @Override
    public RestRequest<List<CurrencyConversion>> build() {
        return RestRequestBuilder.<List<CurrencyConversion>>builder()
                .withPath("/fx/convert").get()
                .withResponse(new GenericType<List<CurrencyConversion>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(amountParams)
                .build();
    }

}
