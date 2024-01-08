package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class DataPointsRequestBuilder extends AbstractStocksRequestBuilder<List<DataPoint>, DataPointsRequestBuilder>
        implements IEXCloudV1RestRequest<List<DataPoint>> {

    public KeyDataPointRequestBuilder withKey(final String key) {
        return new KeyDataPointRequestBuilder(getSymbol(), key);
    }

    @Override
    public RestRequest<List<DataPoint>> build() {
        return RestRequestBuilder.<List<DataPoint>>builder()
                .withPath("/data-points/{symbol}")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<DataPoint>>() {})
                .build();
    }

    public static class KeyDataPointRequestBuilder implements IEXCloudV1RestRequest<String> {

        private final String symbol;
        private final String key;

        public KeyDataPointRequestBuilder(final String symbol, final String key) {
            this.symbol = symbol;
            this.key = key;
        }

        @Override
        public RestRequest<String> build() {
            return RestRequestBuilder.<String>builder()
                    .withPath("/data-points/{symbol}/{key}")
                    .addPathParam("symbol", symbol)
                    .addPathParam("key", key).get()
                    .withResponse(String.class)
                    .build();
        }

    }

}
