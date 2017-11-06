package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.math.BigDecimal;

public class PriceRequestBuilder extends AbstractStocksRequestBuilder<BigDecimal, PriceRequestBuilder> {

    @Override
    public RestRequest<BigDecimal> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/price")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<BigDecimal>() {})
                .build();
    }

}
