package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;

public class CryptoPriceRequestBuilder extends AbstractStocksRequestBuilder<CryptoPrice, CryptoPriceRequestBuilder>
        implements IEXCloudV1RestRequest<CryptoPrice> {

    @Override
    public RestRequest<CryptoPrice> build() {
        return RestRequestBuilder.<CryptoPrice>builder()
                .withPath("/crypto/{symbol}/price")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<CryptoPrice>() {})
                .build();
    }

}
