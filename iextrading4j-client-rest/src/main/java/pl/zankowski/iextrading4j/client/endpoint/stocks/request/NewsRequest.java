package pl.zankowski.iextrading4j.client.endpoint.stocks.request;

/**
 * @author Wojciech Zankowski
 */
public class NewsRequest extends StockRequest {

    private final int range;

    public NewsRequest(String symbol, int range) {
        super(symbol);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public static class Builder {

        private static final String MARKET_NEWS = "market";

        private String symbol;
        private int range = 10;

        public NewsRequest.Builder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public NewsRequest.Builder marketNews() {
            this.symbol = MARKET_NEWS;
            return this;
        }

        public NewsRequest.Builder withRange(int range) {
            validateRange(range);
            this.range = range;
            return this;
        }

        private void validateRange(int range) {
            if (isOutOfRange(range)) {
                throw new IllegalArgumentException("News range must be between 1 and 50");
            }
        }

        private boolean isOutOfRange(int range) {
            return range < 1 || range > 50;
        }

        public NewsRequest build() {
            return new NewsRequest(symbol, range);
        }

    }

}
