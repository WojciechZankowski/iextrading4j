package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.io.Serializable;

public abstract class AbstractStocksRequestBuilder<R extends Serializable, B extends IRestRequestBuilder<R>> implements IRestRequestBuilder<R> {

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public B withSymbol(final String symbol) {
        this.symbol = symbol;
        return (B) this;
    }

}
