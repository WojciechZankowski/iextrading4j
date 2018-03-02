package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

public abstract class AbstractStocksRequestBuilder<R, B extends IRestRequestBuilder<R>> implements IRestRequestBuilder<R> {

    static final String SYMBOL_PARAM_NAME = "symbol";

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public B withSymbol(final String symbol) {
        this.symbol = symbol;
        return (B) this;
    }

}
