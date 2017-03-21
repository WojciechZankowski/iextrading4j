package pl.zankowski.iextrading4j.client.socket.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class LastAsyncRequest extends AsyncRequest {

    public static final String ALL_SYMBOLS = "firehose";
    public static final String SYMBOL_DELIMITER = ",";

    private final String symbolList;

    public LastAsyncRequest(String symbolList) {
        super(AsyncRequestType.LAST);
        this.symbolList = symbolList;
    }

    public String getSymbolList() {
        return symbolList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LastAsyncRequest)) return false;

        LastAsyncRequest that = (LastAsyncRequest) o;

        return symbolList != null ? symbolList.equals(that.symbolList) : that.symbolList == null;
    }

    @Override
    public int hashCode() {
        return symbolList != null ? symbolList.hashCode() : 0;
    }

    public static LastAsyncRequest.Builder builder() {
        return new LastAsyncRequest.Builder();
    }

    public static class Builder {

        private final Set<String> symbols = new HashSet<>();

        public Builder withSymbol(String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public Builder withAllSymbols() {
            this.symbols.clear();
            this.symbols.add(ALL_SYMBOLS);
            return this;
        }

        public LastAsyncRequest build() {
            return new LastAsyncRequest(symbols.stream().collect(Collectors.joining(SYMBOL_DELIMITER)));
        }

    }

}
