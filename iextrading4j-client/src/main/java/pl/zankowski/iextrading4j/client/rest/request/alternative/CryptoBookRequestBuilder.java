package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.CryptoBook;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;

public class CryptoBookRequestBuilder extends AbstractStocksRequestBuilder<CryptoBook, CryptoBookRequestBuilder>
        implements IEXCloudV1RestRequest<CryptoBook> {

    @Override
    public RestRequest<CryptoBook> build() {
        return RestRequestBuilder.<CryptoBook>builder()
                .withPath("/crypto/{symbol}/book")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<CryptoBook>() {})
                .build();
    }

}
