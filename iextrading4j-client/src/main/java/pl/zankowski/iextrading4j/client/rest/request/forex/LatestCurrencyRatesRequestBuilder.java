package pl.zankowski.iextrading4j.client.rest.request.forex;

import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AbstractMarketDataRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class LatestCurrencyRatesRequestBuilder extends AbstractMarketDataRequestBuilder<List<CurrencyRate>,
        LatestCurrencyRatesRequestBuilder> {

    @Override
    public RestRequest<List<CurrencyRate>> build() {
        return RestRequestBuilder.<List<CurrencyRate>>builder()
                .withPath("/fx/latest").get()
                .withResponse(new GenericType<List<CurrencyRate>>() {})
                .addQueryParam(getSymbols())
                .build();
    }
}
