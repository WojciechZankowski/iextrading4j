package pl.zankowski.iextrading4j.api.marketdata;

public enum TradingStatusReasonType {

    HALT_NEWS_PENDING("T1"),
    IPO_ISSUE_NOT_YET_TRADING("IPO1"),
    IPO_ISSUE_DEFERRED("IPOD"),
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3("MCB3"),
    REASON_NOT_AVAILABLE("NA"),

    HALT_NEWS_DISSEMINATION("T2"),
    IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD("IPO2"),
    IPO_PRE_LAUNCH_PERIOD("IPO3"),
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1("MCB1"),
    MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2("MCB2"),

    UNKNOWN("");

    private final String reason;

    TradingStatusReasonType(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public static TradingStatusReasonType getTradingStatusReasonType(String reason) {
        for (TradingStatusReasonType tradingStatusReasonType : values()) {
            if (tradingStatusReasonType.getReason().equals(reason)) {
                return tradingStatusReasonType;
            }
        }
        return TradingStatusReasonType.UNKNOWN;
    }
}
