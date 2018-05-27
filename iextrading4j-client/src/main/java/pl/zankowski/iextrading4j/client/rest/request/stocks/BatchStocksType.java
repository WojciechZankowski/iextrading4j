package pl.zankowski.iextrading4j.client.rest.request.stocks;

public enum BatchStocksType {

    BOOK("book"),
    CHART("chart"),
    COMPANY("company"),
    DELAYED_QUOTE("delayed-quote"),
    DIVIDENDS("dividends"),
    EARNINGS("earnings"),
    EFFECTIVE_SPREAD("effective-spread"),
    FINANCIALS("financials"),
    THRESHOLD_SECURITIES("threshold-securities"),
    SHORT_INTEREST("short-interest"),
    KEY_STATS("stats"),
    LARGEST_TRADES("largest-trades"),
    LOGO("logo"),
    NEWS("news"),
    OHLC("ohlc"),
    PEERS("peers"),
    PREVIOUS("previous"),
    PRICE("price"),
    QUOTE("quote"),
    RELEVANT("relevant"),
    SPLITS("splits"),
    VOLUME_BY_VENUE("volume-by-venue");

    private final String type;

    BatchStocksType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
