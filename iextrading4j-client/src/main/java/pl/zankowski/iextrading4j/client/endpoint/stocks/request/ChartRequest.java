package pl.zankowski.iextrading4j.client.endpoint.stocks.request;

/**
 * @author Wojciech Zankowski
 */
public class ChartRequest extends StockRequest {

    private final ChartRange chartRange;

    public ChartRequest(String symbol, ChartRange chartRange) {
        super(symbol);
        this.chartRange = chartRange;
    }

    public ChartRange getChartRange() {
        return chartRange;
    }

    public static class Builder {

        private String symbol;
        private ChartRange chartRange = ChartRange.ONE_MONTH;

        public ChartRequest.Builder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public ChartRequest.Builder withChartRange(ChartRange chartRange) {
            this.chartRange = chartRange;
            return this;
        }

        public ChartRequest build() {
            return new ChartRequest(symbol, chartRange);
        }

    }

}
