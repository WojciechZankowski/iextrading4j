package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import java.math.BigDecimal;

public class PriceRequestBuilder extends AbstractStocksRequestBuilder<BigDecimal, PriceRequestBuilder> {

    @Override
    public RestRequest<BigDecimal> build() {
        return RestRequestBuilder.<BigDecimal>builder()
                .withPath("/stock/{symbol}/price")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(BigDecimal.class)
                .build();
    }

}
