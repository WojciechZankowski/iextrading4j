package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.PriceTarget;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class PriceTargetRequestBuilder extends AbstractStocksRequestBuilder<PriceTarget, PriceTargetRequestBuilder>
        implements IEXCloudV1RestRequest<PriceTarget> {

    @Override
    public RestRequest<PriceTarget> build() {
        return RestRequestBuilder.<PriceTarget>builder()
                .withPath("/stock/{symbol}/price-target")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(PriceTarget.class)
                .build();
    }

}
