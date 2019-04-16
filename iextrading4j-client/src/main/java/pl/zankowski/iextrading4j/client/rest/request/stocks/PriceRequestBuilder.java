package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import java.math.BigDecimal;

public class PriceRequestBuilder extends AbstractStocksRequestBuilder<BigDecimal, PriceRequestBuilder>
        implements IEXApiRestRequest<BigDecimal>, IEXCloudV1RestRequest<BigDecimal> {

    @Override
    public RestRequest<BigDecimal> build() {
        return RestRequestBuilder.<BigDecimal>builder()
                .withPath("/stock/{symbol}/price")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(BigDecimal.class)
                .build();
    }

}
