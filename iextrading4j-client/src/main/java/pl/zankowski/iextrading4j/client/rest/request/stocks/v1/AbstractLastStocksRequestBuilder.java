package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public abstract class AbstractLastStocksRequestBuilder<R, B extends IRestRequestBuilder<R>>
        extends AbstractStocksRequestBuilder<R, B> {

    protected Integer last;

    public B withLast(final int last) {
        this.last = last;
        return (B) this;
    }

    protected abstract RestRequest<R> request();

    protected abstract RestRequest<R> requestWithLast();

    @Override
    public RestRequest<R> build() {
        if (last != null) {
            return requestWithLast();
        } else {
            return request();
        }
    }

}
