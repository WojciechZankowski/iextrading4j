package pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Wojciech Zankowski
 */
public class TOPSRequest {

    private final String[] symbols;
    private final RequestFilter requestFilter;

    public TOPSRequest(String[] symbols, RequestFilter requestFilter) {
        this.symbols = symbols;
        this.requestFilter = requestFilter;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public Optional<RequestFilter> getRequestFilter() {
        return Optional.ofNullable(requestFilter);
    }

    public static TOPSRequest.Builder builder() {
        return new TOPSRequest.Builder();
    }

    public static class Builder {

        private Set<String> symbols = new HashSet<>();
        private RequestFilter requestFilter;

        public Builder withSymbol(String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public Builder withSymbols(String... symbols) {
            this.symbols.addAll(Arrays.asList(symbols));
            return this;
        }

        public Builder withAllSymbols() {
            this.symbols.clear();
            return this;
        }

        public Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public TOPSRequest build() {
            return new TOPSRequest(symbols.toArray(new String[symbols.size()]), requestFilter);
        }

    }

}
