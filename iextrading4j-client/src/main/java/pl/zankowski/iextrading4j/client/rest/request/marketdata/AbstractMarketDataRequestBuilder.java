package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractMarketDataRequestBuilder<R extends Serializable, B extends IRestRequestBuilder> extends AbstractRequestFilterBuilder<R, B> {

    private Set<String> symbols = new HashSet<>();

    public B withSymbol(String symbol) {
        this.symbols.add(symbol);
        return (B) this;
    }

    public B withSymbols(String... symbols) {
        this.symbols.addAll(Arrays.asList(symbols));
        return (B) this;
    }

    public B withAllSymbols() {
        this.symbols.clear();
        return (B) this;
    }

    protected void applySymbols(IRestParamRequestBuilder builder) {
        if (symbols != null) {
            builder.addQueryParam("symbols", symbols.stream().collect(joining(",")));
        }
    }

}
