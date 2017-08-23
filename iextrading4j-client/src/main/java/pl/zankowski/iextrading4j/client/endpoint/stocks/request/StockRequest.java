package pl.zankowski.iextrading4j.client.endpoint.stocks.request;

/**
 * @author Wojciech Zankowski
 */
public class StockRequest {

    private final String symbol;

    public StockRequest(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockRequest that = (StockRequest) o;

        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;

    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }

    public static StockRequest.Builder builder() {
        return new StockRequest.Builder();
    }

    @Override
    public String toString() {
        return "StockRequest{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static class Builder {

        private String symbol;

        public StockRequest.Builder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public StockRequest build() {
            return new StockRequest(symbol);
        }

    }

}
