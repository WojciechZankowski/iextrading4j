package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class LogoRequestBuilder extends AbstractStocksRequestBuilder<Logo, LogoRequestBuilder> {

    @Override
    public RestRequest<Logo> build() {
        return RestRequestBuilder.<Logo>builder()
                .withPath("/stock/{symbol}/logo")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(Logo.class)
                .build();
    }

}
