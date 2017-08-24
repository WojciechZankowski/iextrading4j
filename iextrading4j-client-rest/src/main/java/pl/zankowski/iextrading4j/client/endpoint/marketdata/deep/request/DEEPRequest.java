package pl.zankowski.iextrading4j.client.endpoint.marketdata.deep.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Wojciech Zankowski
 */
public class DEEPRequest {

    private final String[] symbols;
    private final RequestFilter requestFilter;

    public DEEPRequest(String[] symbols, RequestFilter requestFilter) {
        this.symbols = symbols;
        this.requestFilter = requestFilter;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public Optional<RequestFilter> getRequestFilter() {
        return Optional.ofNullable(requestFilter);
    }

    public static DEEPRequest.Builder builder() {
        return new DEEPRequest.Builder();
    }

    public static class Builder {

        private Set<String> symbols = new HashSet<>();
        private RequestFilter requestFilter;

        public DEEPRequest.Builder withSymbol(String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public DEEPRequest.Builder withSymbols(String... symbols) {
            this.symbols.addAll(Arrays.asList(symbols));
            return this;
        }

        public DEEPRequest.Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public DEEPRequest build() {
            return new DEEPRequest(symbols.toArray(new String[symbols.size()]), requestFilter);
        }

    }

}
