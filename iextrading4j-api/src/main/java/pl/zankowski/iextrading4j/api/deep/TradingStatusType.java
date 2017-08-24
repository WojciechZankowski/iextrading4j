package pl.zankowski.iextrading4j.api.deep;

/**
 * @author Wojciech Zankowski
 */
public enum TradingStatusType {

    TRADING_HALTED('H'),
    ORDER_ACCEPTANCE_PERIOD('O'),
    ORDER_ACCEPTANCE_PERIOD_ON_IEX('P'),
    TRADING_ON_IEX('T'),
    UNKNOWN(' ');

    private final char code;

    TradingStatusType(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static TradingStatusType getTradingStatusType(char code) {
        for (TradingStatusType tradingStatusType : values()) {
            if (tradingStatusType.getCode() == code) {
                return tradingStatusType;
            }
        }
        return TradingStatusType.UNKNOWN;
    }

}
