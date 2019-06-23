package pl.zankowski.iextrading4j.client.sse.request;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractSymbolSseRequestBuilder<R extends Serializable, B extends ISseRequestBuilder<R>>
        extends AbstractSseRequestBuilder<R, B> {

    private Set<String> symbols = new HashSet<>();

    protected Set<String> getSymbols() {
        return symbols;
    }

    protected String getSymbol() {
        return symbols.stream().collect(joining(","));
    }

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
        this.symbols.add("firehose");
        return (B) this;
    }

}