package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

public enum BatchStocksType {

    ADVANCED_STATS("advanced-stats"),
    BALANCE_SHEET("balance-sheet"),
    BOOK("book"),
    CASH_FLOW("cash-flow"),
    CHART("chart"),
    COMPANY("company"),
    DELAYED_QUOTE("delayed-quote"),
    DIVIDENDS("dividends"),
    EARNINGS("earnings"),
    TODAY_EARNINGS("today-earnings"),
    ESTIMATES("estimates"),
    FINANCIALS("financials"),
    FUND_OWNERSHIP("fund-ownership"),
    INCOME("income"),
    INSIDER_ROSTER("insider-roster"),
    INSIDER_SUMMARY("insider-summary"),
    INSIDER_TRANSACTIONS("insider-transactions"),
    INSTITUTIONAL_OWNERSHIP("institutional-ownership"),
    INTRADAY_PRICES("intraday-prices"),
    KEY_STATS("stats"),
    LARGEST_TRADES("largest-trades"),
    LOGO("logo"),
    NEWS("news"),
    OHLC("ohlc"),
    OPTIONS("options"),
    PEERS("peers"),
    PREVIOUS("previous"),
    PRICE("price"),
    PRICE_TARGET("price-target"),
    QUOTE("quote"),
    RECOMMENDATION_TRENDS("recommendation-trends"),
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
