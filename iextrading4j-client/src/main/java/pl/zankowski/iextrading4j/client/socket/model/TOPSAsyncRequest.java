package pl.zankowski.iextrading4j.client.socket.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class TOPSAsyncRequest extends AsyncRequest {

    public static final String ALL_SYMBOLS = "firehose";
    public static final String SYMBOL_DELIMITER = ",";

    private final String symbolList;

    public TOPSAsyncRequest(String symbolList) {
        super(AsyncRequestType.TOPS);
        this.symbolList = symbolList;
    }

    public String getSymbolList() {
        return symbolList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TOPSAsyncRequest)) return false;

        TOPSAsyncRequest that = (TOPSAsyncRequest) o;

        return symbolList != null ? symbolList.equals(that.symbolList) : that.symbolList == null;
    }

    @Override
    public int hashCode() {
        return symbolList != null ? symbolList.hashCode() : 0;
    }

    public static TOPSAsyncRequest.Builder builder() {
        return new TOPSAsyncRequest.Builder();
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

        public TOPSAsyncRequest build() {
            return new TOPSAsyncRequest(symbols.stream().collect(Collectors.joining(SYMBOL_DELIMITER)));
        }

    }

}
