package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.Financials;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class EffectiveSpreadRequestBuilder extends AbstractStocksRequestBuilder<ArrayList<EffectiveSpread>, EffectiveSpreadRequestBuilder> {

    @Override
    public RestRequest<ArrayList<EffectiveSpread>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/effective-spread")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<ArrayList<EffectiveSpread>>() {})
                .build();
    }

}
