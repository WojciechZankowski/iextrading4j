package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import java.util.Map;

public abstract class AbstractLastStocksRequestBuilder<R, B extends IRestRequestBuilder<R>>
        extends AbstractStocksRequestBuilder<R, B> {

    protected Integer last;
    protected final Map<String, String> queryParameters = Maps.newHashMap();

    public B withPeriod(final Period period) {
        this.queryParameters.put("period", period.name().toLowerCase());
        return (B) this;
    }

    public B withLast(final int last) {
        this.last = last;
        return (B) this;
    }

    abstract RestRequest<R> request();

    abstract RestRequest<R> requestWithLast();

    @Override
    public RestRequest<R> build() {
        if (last != null) {
            return requestWithLast();
        } else {
            return request();
        }
    }

}
