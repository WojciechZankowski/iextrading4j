package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class AbstractStockTimeSeriesRequestBuilder<R, B extends IRestRequestBuilder<R>>
        extends AbstractTimeSeriesRequestBuilder<R, B> {

    protected AbstractStockTimeSeriesRequestBuilder(final String dataName, final GenericType<R> responseType) {
        super(dataName, responseType);
    }

    public B withSymbol(final String symbol) {
        return super.withKey(symbol);
    }

    public B withRefId(final String refId) {
        return super.withSubKey(refId);
    }
}
