package pl.zankowski.iextrading4j.client.sse.request.forex;

import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class CurrencyRatesSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<CurrencyRate>,
        CurrencyRatesSseRequestBuilder> {

    @Override
    public SseRequest<List<CurrencyRate>> build() {
        return SseRequestBuilder.<List<CurrencyRate>>builder()
                .withPath("/forex")
                .withResponse(new GenericType<List<CurrencyRate>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
