package pl.zankowski.iextrading.client.socket.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class AsyncRequest {

    public static final String ALL_SYMBOLS = "firehose";
    public static final String SYMBOL_DELIMITER = ",";

    private AsyncRequestType asyncRequestType;
    private String symbolList;

    public AsyncRequest(AsyncRequestType asyncRequestType, String symbolList) {
        this.asyncRequestType = asyncRequestType;
        this.symbolList = symbolList;
    }

    public AsyncRequestType getAsyncRequestType() {
        return asyncRequestType;
    }

    public String getSymbolList() {
        return symbolList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsyncRequest that = (AsyncRequest) o;

        if (asyncRequestType != that.asyncRequestType) return false;
        return symbolList != null ? symbolList.equals(that.symbolList) : that.symbolList == null;
    }

    @Override
    public int hashCode() {
        int result = asyncRequestType != null ? asyncRequestType.hashCode() : 0;
        result = 31 * result + (symbolList != null ? symbolList.hashCode() : 0);
        return result;
    }

    public static AsyncRequest.Builder builder() {
        return new AsyncRequest.Builder();
    }

    public static class Builder {

        private AsyncRequestType asyncRequestType;
        private final Set<String> symbols = new HashSet<>();

        public Builder withAsyncRequestType(AsyncRequestType asyncRequestType) {
            this.asyncRequestType = asyncRequestType;
            return this;
        }

        public Builder withSymbol(String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public Builder withAllSymbols() {
            this.symbols.clear();
            this.symbols.add(ALL_SYMBOLS);
            return this;
        }

        public AsyncRequest build() {
            return new AsyncRequest(asyncRequestType, symbols.stream().collect(Collectors.joining(SYMBOL_DELIMITER)));
        }

    }

}
