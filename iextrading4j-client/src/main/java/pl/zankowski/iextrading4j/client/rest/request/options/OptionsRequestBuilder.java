package pl.zankowski.iextrading4j.client.rest.request.options;

import jakarta.ws.rs.core.GenericType;
import pl.zankowski.iextrading4j.api.options.Option;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import java.util.List;

public class OptionsRequestBuilder extends AbstractStocksRequestBuilder<List<String>, OptionsRequestBuilder>
        implements IEXCloudV1RestRequest<List<String>> {

    private static final String EXPIRATION_DATE_PARAM = "expirationDate";

    public SpecificOptionRequestBuilder withExpirationDate(final String expirationDate) {
        return new SpecificOptionRequestBuilder(expirationDate, getSymbol());
    }

    @Override
    public RestRequest<List<String>> build() {
        return RestRequestBuilder.<List<String>>builder()
                .withPath("/stock/{symbol}/options")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<List<String>>() {
                })
                .build();
    }

    public static class SpecificOptionRequestBuilder extends AbstractStocksRequestBuilder<List<Option>, SpecificOptionRequestBuilder>
            implements IEXCloudV1RestRequest<List<Option>> {

        private String expirationDate;
        private OptionSide side;

        public SpecificOptionRequestBuilder(final String expirationDate, final String symbol) {
            this.expirationDate = expirationDate;
            withSymbol(symbol);
        }

        public SpecificOptionRequestBuilder withSide(final OptionSide side) {
            this.side = side;
            return this;
        }

        private RestRequest<List<Option>> request() {
            return RestRequestBuilder.<List<Option>>builder()
                    .withPath("/stock/{symbol}/options/{expirationDate}")
                    .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                    .addPathParam(EXPIRATION_DATE_PARAM, expirationDate).get()
                    .withResponse(new GenericType<List<Option>>() {
                    })
                    .build();
        }

        private RestRequest<List<Option>> requestWithSide() {
            return RestRequestBuilder.<List<Option>>builder()
                    .withPath("/stock/{symbol}/options/{expirationDate}/{side}")
                    .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                    .addPathParam(EXPIRATION_DATE_PARAM, expirationDate)
                    .addPathParam("side", side.getName()).get()
                    .withResponse(new GenericType<List<Option>>() {
                    })
                    .build();
        }

        @Override
        public RestRequest<List<Option>> build() {
            if (side != null) {
                return requestWithSide();
            }
            return request();
        }

    }

}
