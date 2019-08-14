package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class EffectiveSpreadRequestBuilder extends AbstractStocksRequestBuilder<List<EffectiveSpread>,
        EffectiveSpreadRequestBuilder> implements IEXApiRestRequest<List<EffectiveSpread>> {

    @Override
    public RestRequest<List<EffectiveSpread>> build() {
        return RestRequestBuilder.<List<EffectiveSpread>>builder()
                .withPath("/stock/{symbol}/effective-spread")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<EffectiveSpread>>() {})
                .build();
    }

}
